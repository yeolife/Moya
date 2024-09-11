<<<<<<< HEAD
-- Parksp
=======
>>>>>>> 3c2a0e63c7b9f199925d1933d62250ec919940f3
INSERT INTO park (name, description, image_url)
VALUES ('싸피 뒷뜰', '싸피 구미 캠퍼스 기숙사에 위치한 공원으로 봄이 되면 예쁜 꽃들이 핀답니다. 가을이 되면 감도 딸 수 있어요',
        'https://example.com/seoul-forest.jpg'),
       ('동락공원', '아름다운 낙동강을 끼고 있는 넓은 산책로와 자전거 도로를 갖춘 도심 속 힐링 공간이에요. 산책로와 잔디밭이 있어서 마음껏 뛰어놀 수 있어요.
공원에는 농구장, 축구장, 배구장, 그리고 롤러스케이트장등 여러 가지 운동 시설도 많이 있어요. 시원한 바닥분수도 있어 시원한 여름을 보낼 수 있어요.
그리고 무료로 자전거를 대여할 수 있으니 자전거 타는 것도 잊지 마세요. 신나는 동락공원을 꼭 방문해보아요!',
        'https://example.com/olympic-park.jpg'),
       ('환경 연수원', '금오산 도립공원 구역 내에 위치하고 있는 수련 시설로 수생태체험학습장, 야외학습체험장 등등 다양한 학습 공간이 있어요.',
        'https://example.com/worldcup-park.jpg');

<<<<<<< HEAD
-- Park Position
=======
>>>>>>> 3c2a0e63c7b9f199925d1933d62250ec919940f3
INSERT INTO park_pos (latitude, longitude, park_id, name)
VALUES (36.107442, 128.410590, 1, '정문'),      -- 싸피 뒷뜰
       (36.107535, 128.417373, 1, '후문'),      -- 싸피 뒷뜰
       (36.105738, 128.416504, 1, '개구멍'),     -- 싸피 뒷뜰
       (36.104893, 128.402023, 2, '북쪽 입구'),   -- 동락공원
       (36.101802, 128.401838, 2, '1 주차장'),   -- 동락공원
       (36.098217, 128.402133, 2, '중간 입구 1'), -- 동락공원
       (36.096804, 128.402455, 2, '중간 입구 2'), -- 동락공원
       (36.093575, 128.403072, 2, '4 주차장'),   -- 동락공원
       (36.092183, 128.403209, 2, '중간 입구'),   -- 동락공원
       (36.091906, 128.403233, 2, '5 주차장'),   -- 동락공원
       (36.089234, 128.402881, 2, '중간 입구'),   -- 동락공원
       (36.089024, 128.402859, 2, '6 주차장'),   -- 동락공원
       (36.085257, 128.400617, 2, '아래 입구'),   -- 동락공원
       (36.084151, 128.399493, 2, '7 주차장'),   -- 동락공원
       (36.083426, 128.398673, 2, '젤 아래 입구'), -- 동락공원
<<<<<<< HEAD
       (36.119622, 128.311031, 3, '환경 연수원 입구'); -- 환경 연수원

-- NPC
=======
       (36.119622, 128.311031, 3, '환경 연수원 입구'); -- 동락공원

>>>>>>> 3c2a0e63c7b9f199925d1933d62250ec919940f3
INSERT INTO npc (name)
VALUES ('수달'),
       ('검사 수달'),
       ('기도하는 수달'),
       ('너구리'),
       ('마법사 너구리'),
       ('병아리'),
       ('거북이'),
       ('갈색 거북이'),
       ('토끼'),
       ('이정표'),
       ('펭귄'),
       ('돛새치');

<<<<<<< HEAD
-- Park NPCs
INSERT INTO park_npc (park_id, npc_id)
VALUES (1, 1), (1, 2), (1, 7), (1, 10),  -- 싸피 뒷뜰
       (2, 3), (2, 4), (2, 8), (2, 11),  -- 동락공원
       (3, 5), (3, 6), (3, 9), (3, 12);  -- 환경 연수원

-- NPC Position
INSERT INTO npc_pos (latitude, longitude, park_npc_id)
VALUES (36.107000, 128.416000, 1),  -- 싸피 뒷뜰 - 수달
       (36.107200, 128.416200, 2),  -- 싸피 뒷뜰 - 검사 수달
       (36.100000, 128.402000, 5),  -- 동락공원 - 기도하는 수달
       (36.095000, 128.402500, 6),  -- 동락공원 - 너구리
       (36.119000, 128.311500, 9);  -- 환경 연수원 - 마법사 너구리

-- Species
INSERT INTO species (name, scientific_name, description, image_url)
VALUES ('청설모', 'Sciurus vulgaris', '귀여운 다람쥐과의 포유류', 'https://example.com/squirrel.jpg'),
       ('왕벚나무', 'Prunus yedoensis', '봄에 아름다운 꽃을 피우는 나무', 'https://example.com/cherry-tree.jpg'),
       ('잉어', 'Cyprinus carpio', '연못에서 흔히 볼 수 있는 물고기', 'https://example.com/carp.jpg'),
       ('참새', 'Passer montanus', '도시에서 흔히 볼 수 있는 작은 새', 'https://example.com/sparrow.jpg'),
       ('단풍나무', 'Acer palmatum', '가을에 아름다운 단풍을 보여주는 나무', 'https://example.com/maple.jpg'),
       ('개구리', 'Rana coreana', '한국에서 흔히 볼 수 있는 개구리', 'https://example.com/frog.jpg');

-- Park Species
INSERT INTO park_species (park_id, species_id)
VALUES (1, 1), -- 싸피 뒷뜰 - 청설모
       (1, 2), -- 싸피 뒷뜰 - 왕벚나무
       (1, 4), -- 싸피 뒷뜰 - 참새
       (2, 2), -- 동락공원 - 왕벚나무
       (2, 3), -- 동락공원 - 잉어
       (2, 5), -- 동락공원 - 단풍나무
       (3, 1), -- 환경 연수원 - 청설모
       (3, 5), -- 환경 연수원 - 단풍나무
       (3, 6); -- 환경 연수원 - 개구리

-- Species Position
INSERT INTO species_pos (latitude, longitude, park_species_id)
VALUES (36.107000, 128.416000, 1), -- 싸피 뒷뜰 - 청설모
       (36.107200, 128.416200, 2), -- 싸피 뒷뜰 - 왕벚나무
       (36.107400, 128.416400, 3), -- 싸피 뒷뜰 - 참새
       (36.100000, 128.402000, 4), -- 동락공원 - 왕벚나무
       (36.095000, 128.402500, 5), -- 동락공원 - 잉어
       (36.090000, 128.403000, 6), -- 동락공원 - 단풍나무
       (36.119000, 128.311500, 7), -- 환경 연수원 - 청설모
       (36.119500, 128.311700, 8), -- 환경 연수원 - 단풍나무
       (36.120000, 128.312000, 9); -- 환경 연수원 - 개구리

-- Quest
INSERT INTO quest (id)
VALUES (1),
       (2),
       (3);
=======

INSERT INTO npc_pos (latitude, longitude, npc_id)
VALUES (37.5446, 127.0375, 1),
       (37.5203, 127.1215, 2),
       (37.5682, 126.8975, 3);

INSERT INTO species (name, scientific_name, description, image_url)
VALUES ('청설모', 'Sciurus vulgaris', '귀여운 다람쥐과의 포유류', 'https://example.com/squirrel.jpg'),
       ('왕벚나무', 'Prunus yedoensis', '봄에 아름다운 꽃을 피우는 나무', 'https://example.com/cherry-tree.jpg'),
       ('잉어', 'Cyprinus carpio', '연못에서 흔히 볼 수 있는 물고기', 'https://example.com/carp.jpg');

INSERT INTO species_pos (latitude, longitude, species_id)
VALUES (37.5447, 127.0376, 1),
       (37.5204, 127.1216, 2),
       (37.5683, 126.8976, 3);


INSERT INTO quest (id)
VALUES (1),
       (2);
>>>>>>> 3c2a0e63c7b9f199925d1933d62250ec919940f3
