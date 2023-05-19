const gameController = require("../game");

const mockId = 'fda56100-0ddb-4f06-9ea4-7c1919ff6d2f';
jest.mock("uuid", () => ({ v4: () => mockId }));

describe("game controller", () => {
    describe("createGame", () => {
      it("Should return identifier when game created", () => {
        const req = {};
        const res = {
            send: jest.fn()
        };

        gameController.createGame(req, res);

        expect(res.send).toHaveBeenCalledTimes(1);
        expect(res.send).toHaveBeenCalledWith(id);
      });
    });
});