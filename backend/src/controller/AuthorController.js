import AuthorService from "../service/AuthorService.js";

class AuthorController {
    #service;
    constructor() {
        this.#service = new AuthorService();
        this.create = this.create.bind(this);
        this.updateBalance = this.updateBalance.bind(this);
    }

    async create(request, response) {
        const {body} = request;

        console.log('start at', new Date());
        console.log('start at', new Date().getTime());
        console.log(body.name);
        const newAuthor = await this.#service.createAuthor(body)

        return response.status(200).json({message: "Success", author: newAuthor});
    }

    async updateBalance(request, response) {
        const {body} = request;

        console.log('start at', new Date());
        console.log('start at', new Date().getTime());
        console.log(body.name);
        const result = await this.#service.updateBalance(body);

        return response.status(200).json({message: "Success", isUpdated: result});
    }
}

export default AuthorController;