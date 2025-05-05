import DatabaseConfig from "../config/DatabaseConfig.js";
import {DataTypes} from "sequelize";

const sequelize = DatabaseConfig.sequelize;

const publisher = sequelize.define(
    'publisher',
    {
        id: {
            type: DataTypes.INTEGER,
            autoIncrement: true,
            primaryKey: true
        },
        name: {
            type: DataTypes.STRING(50),
        },
    },
    {
        timestamps: false,
        tableName: "publisher"
    }
)

export default publisher;