import {Sequelize, Transaction} from "sequelize";

class DatabaseConfig {
    static sequelize;

    static getConnection() {
        if(this.sequelize == null) {
            DatabaseConfig.initConnection();
        }
        return DatabaseConfig.sequelize;
    }

    static initConnection() {
        DatabaseConfig.sequelize = new Sequelize('mariadb://root:@localhost:3306/book_depository');
    }
}

export default DatabaseConfig;