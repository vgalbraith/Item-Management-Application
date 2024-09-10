CREATE TABLE Accounts (
	account_id serial PRIMARY KEY,
	username varchar(50) UNIQUE NOT NULL,
	password varchar(50) NOT NULL,
    CHECK (CHAR_LENGTH(password) >= 4)
);

CREATE TABLE video_games (
	game_id serial PRIMARY KEY,
	title varchar(100) NOT NULL,
    platform VARCHAR(50),
	owned_by int REFERENCES Accounts(account_id) ON DELETE SET NULL
);
