package repository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BaseRepository {
    private PreparedStatement preparedStatement;
    protected ResultSet         resultSet;
    private Connection        connection;
    private static final String  JDBC_DRIVER = "com.mysql.jdbc.driver";
    private static final String  DB_URL      = "jdbc:mysql://localhost:3306/ProjectDrawDB";
    private static final String  USER_NAME   = "root";
    private static final String  PASSWORD    = "root";
    private              boolean isOpen      = false;
    private String query;
    protected int    resultForExecuteUpdate;
    private boolean ranQuery = false;
    private long lastQueryRunTime;

    /**
     * Opens connection.
     */
    public void openConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);;
            this.isOpen = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createPreparedStatement(ArrayList<Object> args) {
        try {
            if (!this.isOpen) this.openConnection();
            if (!this.query.toLowerCase().startsWith("select")) {
                this.preparedStatement = this.connection.prepareStatement(this.query, Statement.RETURN_GENERATED_KEYS);
            } else {
                this.preparedStatement = this.connection.prepareStatement(this.query);
            }

            int index = 0;
            for (Object arg : args) {
                String[] arrayArg;
                if (arg instanceof Integer) {
                    if (arg.toString().contains(",")) {
                        arrayArg = arg.toString().split(",");
                        for (String anArrayArg : arrayArg) {
                            int argument = Integer.parseInt(anArrayArg);
                            this.preparedStatement.setInt(++index, argument);
                        }
                    } else {
                        this.preparedStatement.setInt(++index, (Integer) arg);
                    }
                } else if (arg instanceof Float) {
                    if (arg.toString().contains(",")) {
                        arrayArg = arg.toString().split(",");
                        for (String anArrayArg : arrayArg) {
                            float argument = Float.parseFloat(anArrayArg);
                            this.preparedStatement.setFloat(++index, argument);
                        }
                    } else {
                        this.preparedStatement.setFloat(++index, (Float) arg);
                    }

                } else if (arg instanceof Double) {
                    if (arg.toString().contains(",")) {
                        arrayArg = arg.toString().split(",");
                        for (String anArrayArg : arrayArg) {
                            double argument = Double.parseDouble(anArrayArg);
                            this.preparedStatement.setDouble(++index, argument);
                        }
                    } else {
                        this.preparedStatement.setDouble(++index, (Double) arg);
                    }
                } else if (arg instanceof Long) {
                    if (arg.toString().contains(",")) {
                        arrayArg = arg.toString().split(",");
                        for (String anArrayArg : arrayArg) {
                            long argument = Long.parseLong(anArrayArg);
                            this.preparedStatement.setLong(++index, argument);
                        }
                    } else {
                        this.preparedStatement.setLong(++index, (Long) arg);
                    }
                } else if (arg instanceof java.util.Date) {
                    if (arg.toString().contains(",")) {
                        arrayArg = arg.toString().split(",");
                        for (String anArrayArg : arrayArg) {
                            java.sql.Date sqlDate = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(anArrayArg).getTime());
                            this.preparedStatement.setDate(++index, sqlDate);
                        }
                    } else {
                        this.preparedStatement.setDate(++index, (java.sql.Date) arg);
                    }

                } else {
                    if (arg.toString().contains(",") && !arg.toString().contains("{") && !arg.toString().contains("}")) {
                        arrayArg = arg.toString().split(",");
                        for (String anArrayArg : arrayArg) {
                            this.preparedStatement.setString(++index, anArrayArg);
                        }
                    } else {
                        this.preparedStatement.setString(++index, (String) arg);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected BaseRepository runQuery(ArrayList<Object> args) {
        try {
            createPreparedStatement(args);
            java.util.Date startDate = new java.util.Date();
            if (!this.query.toLowerCase().startsWith("select")) {
                this.resultForExecuteUpdate = this.preparedStatement.executeUpdate();
                this.resultSet = this.preparedStatement.getGeneratedKeys();
            } else {
                this.resultSet = this.preparedStatement.executeQuery();
            }
            java.util.Date endDate = new java.util.Date();
            this.lastQueryRunTime = endDate.getTime() - startDate.getTime();
            this.ranQuery = true;
        } catch (Exception e) {
            this.cleanResources();
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Frees ResultSet, Statement and Connection variables.
     */
    public void cleanResources() {
        try {
            this.query = "";
            if (this.resultSet != null) {
                resultSet.close();
                this.resultSet = null;
            }
            if (this.preparedStatement != null) {
                preparedStatement.close();
                this.preparedStatement = null;
            }
            if (this.connection != null) {
                this.closeConnection();
            }
            this.ranQuery = false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (this.connection != null) this.closeConnection();
            this.ranQuery = false;
        }
    }

    public void closeConnection() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
            this.isOpen = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setQuery(String query) {
        this.query = query;
    }
}