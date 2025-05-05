import DatabaseConfig from "../config/DatabaseConfig.js";
import {DataTypes, Deferrable} from "sequelize";
import Author from "./Author.js";
import Publisher from "./Publisher.js";

const sequelize = DatabaseConfig.sequelize;

const book = sequelize.define(
    'book',
    {
        id: {
            type: DataTypes.INTEGER,
            autoIncrement: true,
            primaryKey: true
        },
        name: {
            type: DataTypes.STRING(250),
        },
        author: {
            type: DataTypes.INTEGER,
            references: {
                model: Author,
                key: 'id',
                deferrable: Deferrable.INITIALLY_IMMEDIATE,
            }
        },
        publisher: {
            type: DataTypes.INTEGER,
            references: {
                model: Publisher,
                key: 'id',
                deferrable: Deferrable.INITIALLY_IMMEDIATE,
            }
        },
        published_date: {
            type: DataTypes.DATE,
        }
    },
    {
        timestamps: false,
        tableName: "book"
    }
)

export default book;