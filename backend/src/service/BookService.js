import DatabaseConfig from "../config/DatabaseConfig.js";
import Book from "../model/Book.js";

class BookService {
    #model;

    constructor() {
        this.#model = Book;
    }

    async createBook(book) {
        return await DatabaseConfig.getConnection().transaction(async transaction => {
            return await this.#model.create({
                name: book.name,
                author: book.author,
                publisher: book.publisher,
                published_date: book.published_date
            }, {transaction});
        });
    }
}

export default BookService;