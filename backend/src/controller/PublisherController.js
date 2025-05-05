import PublisherService from "../service/PublisherService.js";


class PublisherController {
    #service;
    constructor() {
        this.#service = new PublisherService();
        this.create = this.create.bind(this);
    }

    async create(request, response) {
        const {body} = request;

        const newPublisher = await this.#service.createPublisher(body)

        return response.status(200).json({message: "Success", publisher: newPublisher});
    }
}

export default PublisherController;