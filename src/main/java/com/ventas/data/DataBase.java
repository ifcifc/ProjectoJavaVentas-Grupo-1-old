package com.ventas.data;

import com.ventas.models.BaseModel;
import com.ventas.utils.FileRead;
import org.sqlite.SQLiteDataSource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DataBase {
    public static final String DB_PATH = "ArticulosDB.sqlite";
    private final SQLiteDataSource dataSource;

    public DataBase() {
        this.dataSource = new SQLiteDataSource();

        boolean dbFile = new File(DB_PATH).exists();

        this.dataSource.setUrl("jdbc:sqlite:" + DB_PATH);

        try (Connection conn = this.dataSource.getConnection()) {
            System.out.println("Conexión con DataSource establecida.");

            if (!dbFile){
                Statement statement = conn.createStatement();
                statement.executeUpdate(FileRead.read("VentasDB.sql"));
                statement.close();
            }

        } catch (SQLException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public SQLiteDataSource getDataSource() {
        return dataSource;
    }

    public HashMap<String, Object> toMap(ResultSet resultSet) throws SQLException {
        HashMap<String, Object> parse = new HashMap<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        for(int i=1;i<metaData.getColumnCount();i++){
            parse.put(metaData.getColumnName(i),
                    this.getValue(resultSet, i));
        }

        return parse;
    }

    public <T extends BaseModel> ArrayList<T> parseResults(ResultSet resultSet, Class<T> modelClass) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        ArrayList<T> ret = new ArrayList<>();

        while ( resultSet.next() ) {
            ret.add(this.parseResult(resultSet, modelClass));
        }

        return ret;
    }

    public <T extends BaseModel> T parseResult(ResultSet resultSet, Class<T> modelClass) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        T ret = modelClass.newInstance();

        Field[] declaredFields = modelClass.getDeclaredFields();
        for(int i=1;i<metaData.getColumnCount();i++){
            String columnName = metaData.getColumnName(i);
            boolean existField = Arrays.stream(declaredFields).anyMatch(field -> field.getName().equals(columnName));
            if(!existField)continue;
            Field declaredField = modelClass.getDeclaredField(columnName);
            declaredField.setAccessible(true);
            declaredField.set(ret, this.getValue(resultSet, i));
        }

        return ret;
    }

    private Object getValue(ResultSet resultSet, int column) throws SQLException {
        String columnTypeName = resultSet.getMetaData().getColumnTypeName(column);

        switch (columnTypeName){
            case "BOOLEAN": return resultSet.getBoolean(column);
            default: return resultSet.getObject(column);
        }
    }

}
