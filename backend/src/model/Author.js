import DatabaseConfig from "../config/DatabaseConfig.js";
import {DataTypes} from "sequelize";

const sequelize = DatabaseConfig.getConnection();

const author = sequelize.define(
    'author',
    {
        id: {
            type: DataTypes.INTEGER,
            autoIncrement: true,
            primaryKey: true
        },
        name: {
            type: DataTypes.STRING(50),
        },
        balance: {
            type: DataTypes.INTEGER,
        },
    },
    {
        timestamps: false,
        tableName: "author"
    }
)

export default author;