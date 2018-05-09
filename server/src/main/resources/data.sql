INSERT INTO maps (name, occupied) VALUES
  ("Map 1", false),
  ("Map 2", false),
  ("Map 3", false),
  ("Map 4", false);

INSERT INTO lamps (lat, lng, map_id) VALUES
  (59.407979, 17.945867, 1),
  (59.406722, 17.942627, 1),
  (59.410099, 17.941377, 2),
  (59.407732, 17.947039, 3);
  
INSERT INTO users (user_name, password) VALUES
  ("user1", "password1"),
  ("user2", "password2"),
  ("user3", "password3"),
  ("user4", "password4");