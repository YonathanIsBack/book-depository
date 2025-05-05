import Author from "../model/Author.js";
import DatabaseConfig from "../config/DatabaseConfig.js";
import {Transaction} from "sequelize";

class AuthorService {
    #model;

    constructor() {
        this.#model = Author;
    }

    async updateBalance(author) {
        try{
            return await DatabaseConfig.getConnection().transaction(async transaction => {
                const foundAuthor = await this.#model.findOne(
                    {
                        where: {id: author.id},
                        transaction,
                        lock: transaction.LOCK.UPDATE
                    }
                    );
                console.log('found author', foundAuthor);
                const updatedBalance = foundAuthor.balance - author.balance;
                if (updatedBalance < 0) {
                    return false;
                }
                await this.#model.update({balance: updatedBalance}, {
                    where: {
                        id: author.id
                    },
                    transaction,
                    lock: transaction.LOCK.UPDATE
                })
                if (foundAuthor.id === 42) {
                    await this.sleep(15000);
                }
                return true;
            });
        }catch (e) {
            console.log(e);
            return false;
        }
    }

    async createAuthor(author) {
        return await DatabaseConfig.getConnection().transaction(async transaction => {
            const newAuthor = await this.#model.create({name: author.name}, {
                transaction, lock: transaction.LOCK.UPDATE
            });
            if (newAuthor.name === 'Vulpis') {
                await this.sleep(20000);
            }
            return newAuthor;
        });
    }

    sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

export default AuthorService;