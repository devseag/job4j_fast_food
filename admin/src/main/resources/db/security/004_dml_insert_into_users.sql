insert into users (name, enabled, password, authority_id)
values ('admin', true, '$2a$10$VBiaX77TgOuUYzh4MO3d5O9tvLSCVMntdVy1PDLe24KyyP7vzOBSK',
(select id from authorities where authority = 'ROLE_ADMIN'));