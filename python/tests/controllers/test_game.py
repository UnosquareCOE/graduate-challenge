import unittest
from unittest.mock import patch
from controllers.game import start_game

def mock_uuid():
    return uuid.UUID("06335e84-2872-4914-8c5d-3ed07d2a2f16")

class TestGameController(unittest.TestCase):

    @patch('uuid.uuid4', mock_uuid)
    def test_create_game_returns_valid_id(self):
        id, code = start_game()
        self.assertEqual(code, 201)
        self.assertEqual(id, "06335e84-2872-4914-8c5d-3ed07d2a2f16")


if __name__ == '__main__':
    unittest.main()