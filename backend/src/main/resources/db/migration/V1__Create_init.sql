-- ユーザー
CREATE TABLE users (
    id VARCHAR(20) NOT NULL,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
);

-- サンプル
CREATE TABLE sample (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    PRIMARY KEY (`id`)
);
