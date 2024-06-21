USE MangaNoob;

CREATE TABLE `Users` (
                         `user_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `image` varchar(255),
                         `email` varchar(255) NOT NULL,
                         `name` varchar(255) NOT NULL,
                         `password` varchar(60) NOT NULL,
                         `role_id` int NOT NULL
);
CREATE TABLE `Roles` (
                         `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `role_name` varchar(255) NOT NULL,
                         `created_at` datetime NOT NULL,
                         `updated_at` datetime NOT NULL
);
CREATE TABLE `Permissions` (
                               `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `permission_name` varchar(255) NOT NULL,
                               `created_at` datetime NOT NULL,
                               `updated_at` datetime NOT NULL
);

CREATE TABLE `PermissionsRole` (
                                   `permission_id` int NOT NULL,
                                   `role_id` int NOT NULL
);
