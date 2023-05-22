import uuid
import random

from flask import (Blueprint, abort, jsonify, request)
from werkzeug.exceptions import HTTPException

mod = Blueprint('games', __name__, url_prefix='/games')

games = {}

word_list = ["Banana", "Canine", "Unosquare", "Airport"]

def generate_word():
    return random.choice(word_list)

def mask_word(word, guessed_letters):
    masked_word = ""
    for letter in word:
            masked_word += "_"
    return masked_word.strip()

def is_valid_guess(guess, game):
    if not guess.isalpha() or len(guess) != 1:
        return False
    return True

@mod.route('/', methods=['POST'])
def start_game():
    game_id = str(uuid.uuid4())
    word = generate_word()
    games[game_id] = {
        "word": word,
        "guessed_letters": [],
        "attempts": 6
    }
    return game_id, 201

@mod.route('/<string:game_id>', methods=['GET'])
def get_game_state(game_id):
    game = games.get(game_id)
    if game is None:
        abort(404)
    masked_word = mask_word(game["word"], game["guessed_letters"])
    return jsonify({
        "incorrect_guesses": game["guessed_letters"],
        "remaining_attempts": game["attempts"],
        "status": "In Progress",
        "word": masked_word,
    })

@mod.route('/<string:game_id>/guesses', methods=['POST'])
def make_guess(game_id):
    game = games.get(game_id)
    if game is None:
        abort(404)
    if not request.json or 'letter' not in request.json:
        abort(400)
    guess = request.json['letter'].lower()
    if not is_valid_guess(guess, game):
        return jsonify({"Message": "Guess must be supplied with 1 letter"}), 400
    
    masked_word = mask_word(game["word"], game["guessed_letters"])

    return jsonify({
        "incorrect_guesses": game["guessed_letters"],
        "remaining_attempts": game["attempts"],
        "status": "In Progress",
        "word": masked_word,
    })