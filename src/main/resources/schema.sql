CREATE TABLE IF NOT EXISTS characters (
                                          id INTEGER PRIMARY KEY,
                                          type VARCHAR(20) NOT NULL,
    name VARCHAR(100),
    dnd_class VARCHAR(30),
    species VARCHAR(30),
    level INTEGER,
    exp INTEGER
    );

ALTER TABLE characters ADD COLUMN IF NOT EXISTS damage INTEGER;
ALTER TABLE characters ADD COLUMN IF NOT EXISTS crit_chance DOUBLE PRECISION;
ALTER TABLE characters ADD COLUMN IF NOT EXISTS healing_power INTEGER;
ALTER TABLE characters ADD COLUMN IF NOT EXISTS has_revive BOOLEAN;
ALTER TABLE characters ADD COLUMN IF NOT EXISTS armor INTEGER;
ALTER TABLE characters ADD COLUMN IF NOT EXISTS aggro_multiplier DOUBLE PRECISION;