/*
 어드민 1명, 매니저 1명, 유저 38명 INSERT
 */
INSERT INTO users (exp, created_at, last_modified_at, auth_token, email, nickname, password, profile_image_url,
                   provider, role)
VALUES (0, '2023-05-31 10:00:00', '2023-05-31 12:00:00', 'NAVER_HP6Yyh7SIkk8QS1VFtEylxrxo23UxNTBHcAjfTw-BHM', null,
        'bayy', null, null, 'NAVER', 'ADMIN'),
       (0, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test1@a.c', 'testUser1',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'MANAGER'),
       (49, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test0@a.c', '이원',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (94, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test1@a.c', '재광',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (87, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test2@a.c', '조한',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (87, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test3@a.c', '태혁',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (47, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test4@a.c', '태윤',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (43, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test5@a.c', '예승',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (83, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test6@a.c', '효신',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (52, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test7@a.c', '준범',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (68, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test8@a.c', '소담',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (40, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test9@a.c', '준섭',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (32, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test10@a.c', '강은',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (17, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test11@a.c', '의빈',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (3, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test12@a.c', '승지',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (66, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test13@a.c', '휘서',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (60, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test14@a.c', '영후',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (25, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test15@a.c', '형우',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (38, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test16@a.c', '희범',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (31, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test17@a.c', '효범',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', null, null, 'USER'),
       (57, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test0@a.c', '기태',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/se/U2uEiDz/640/480',
        null, 'USER'),
       (28, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test1@a.c', '한서',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/se/MSVzesxY/640/480',
        null, 'USER'),
       (38, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test2@a.c', '승리',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/se/KUZmdj5Zn/640/480',
        null, 'USER'),
       (87, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test3@a.c', '찬석',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=4114472343961600', null, 'USER'),
       (76, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test4@a.c', '은현',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=4231310094630912', null, 'USER'),
       (15, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test5@a.c', '성권',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=4323334812598272', null, 'USER'),
       (21, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test6@a.c', '찬휘',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=8502500980162560', null, 'USER'),
       (90, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test7@a.c', '충만',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/seed/IkQoFVE/640/480',
        null, 'USER'),
       (31, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test8@a.c', '태식',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=1946817203798016', null, 'USER'),
       (13, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test9@a.c', '순규',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=1005792186597376', null, 'USER'),
       (57, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test10@a.c', '성빈',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com40/480?lock=5094699765334016', null, 'USER'),
       (0, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test11@a.c', '조슈',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=7842715689549824', null, 'USER'),
       (0, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test12@a.c', '성목',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/seed/T0GXvPB9C5/640/480',
        null, 'USER'),
       (65, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test13@a.c', '주엽',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/sd/GTUgLFvuZ/640/480',
        null, 'USER'),
       (79, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test14@a.c', '지섭',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK', 'https://picsum.photos/sd/HqevoSPB/640/480',
        null, 'USER'),
       (9, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test15@a.c', '혜승',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com/0/480?lock=3226888453488640', null, 'USER'),
       (15, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test16@a.c', '모세',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com40/480?lock=929401032146944', null, 'USER'),
       (64, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test17@a.c', '혁주',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com40/480?lock=1474097934499840', null, 'USER'),
       (64, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test18@a.c', '예솔',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com40/480?lock=5535552531070976', null, 'USER'),
       (38, '2023-05-31 10:00:00', '2023-05-31 12:00:00', null, 'test19@a.c', '근영',
        '$2a$10$h1VlKrjjHSnuRoeCnl1reOh.oaAw6EqxrSMB0FVClpOb1S2D.K.ZK',
        'https://loremflickr.com40/480?lock=7618880130252800', null, 'USER');


/*
챌린지 그룹 20개 INSERT
 */
INSERT INTO challenge_group (cumulative_count, created_at, last_modified_at, content, title, category)
VALUES (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '아니하는 보호를 다만, 보장하기 가진다. 승인된 모성의 무상으로 보호한다.. 재외국민을 죄를 보호할. 노력하여야 판결이 필요한.', '창달에 영장을 헌법에', 'SHARE'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '사생활의 의하여 법률에 무상으로 범죄에 보장하기. 이상의 증거인멸의 사생활의 범하고 통신·방송의 정하는. 조약과 창달에 정하는 처벌받지 승인된 노력하여야 국민은 사후에 범하고 3년.
헌법에 사항은 사후에 범하고 진다. 현행범인인. 범죄를 진다. 증거인멸의. 체결·공포된 이상의 죄를.
대하여 통신·방송의 창달에 보호를 범죄에 무죄로 사후에 필요한 의무교육은 범죄에. 위하여 한다. 법률이 청구할 국가는 보호를 염려가 계승·발전과 보장하기. 무죄로 위하여 ', '행위시의 법률로써 의무교육은', 'HEALTH'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '계승·발전과 법률이 다만, 영장을 창달에 구성하지 일반적으로. 국민은 유죄의 행위로 판결이 모든 신문의 무상으로. 거듭 대하여 신문의 있다..', '도피 수 신문의', 'SHARE'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '침해받지 정한다. 기능을 확정될. 의무를 진흥하여야 시설기준과 권리는 현행범인인. 법률이 신문의 예술가의.
승인된 소추되지 재외국민을 경우와 진다. 필요한 노력하여야 정한다.. 같은 무죄로 통신·방송의 사항은 모성의 기능을 영장을 법률로 또는. 예술가의 무상으로 아니하는 진흥하여야 추정된다. 또는 무죄로 때까지는 바에 소추되지.
증거인멸의 국내법과 신문의 있다. 장기 형사피고인은 정하는 평생교육을 소추되지. 죄를 염려가 때에는. 전통문화의 전통문화의 ', '같은 한다. 행위시의', 'SHARE'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '범죄에 국민은 전통문화의 바에 확정될 수 승인된. 형사피고인은 정하는 무죄로. 범죄를 때까지는 보호를 염려가 한다. 있을 처벌받지 통신·방송의 한다. 처벌받지.
보장하기 가진다. 법률이 가진다. 행위시의 확정될 현행범인인 소추되지. 행위로 법률에 국민은 있다.. 아니하며, 비밀과 아니하며, 거듭 국민은.
승인된 가진다. 권리는 필요한 보장하기. 진다. 사항은 위하여 판결이 형에 노력하여야. 도피 법률에 창달에 때에는 기능을.', '거듭 법률로 범하고', 'HEALTH'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '법률로 행위시의 비밀과 같은 추정된다. 효력을 수 판결이 법률로 처벌받지.', '다만, 노력하여야 이상의', 'ECHO'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '진흥하여야 형에 대하여 청구할 의하여.', '의하여 가진다. 국제법규는', 'HEALTH'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '거듭 추정된다. 헌법에 아니하며, 시설기준과 신체의 사항은 형사피고인은 전통문화의. 헌법에 저작자·발명가·과학기술자와 보호를 노력하여야.
시설기준과 창달에 신체의. 처벌받지 영장을 국민은 체결·공포된 국민은 체결·공포된 유죄의. 다만, 국제법규는 영장을 기능을 범죄를.
계승·발전과 아니하며, 조약과 의무교육은. 보호한다. 진흥하여야 추정된다. 비밀과 신문의 비밀과 ', '보호를 처벌받지 형에', 'VOLUNTEER'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '염려가 유죄의 형에 한다. 필요한 헌법에 법률이 장기 법률이 있을.
장기 증거인멸의 국내법과 법률이 있을 신문의 형에.
보호를 범하고 체결·공포된 때에는 청구할 평생교육을 한다. 있다. 기능을 다만,.
영장을 현행범인인 민족문화의 국내법과 시설기준과 무상으로.', '증거인멸의 법률에 또는', 'VOLUNTEER'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '때에는 있다. 국민은 행위로 국제법규는 비밀과 바에.', '행위시의 유죄의 있을', 'HEALTH'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '시설기준과 정한다. 통신·방송의.', '자유를 시설기준과 신문의', 'ECHO'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '무죄로 시설기준과 법률에 한다. 평생교육을 민족문화의 보장하기. 아니하는 확정될 무죄로. 재외국민을 경우와 범하고 정하는 확정될 의무교육은 바에.', '국민은 사후에 증거인멸의', 'ECHO'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '헌법에 효력을 아니하며, 의무교육은. 통신·방송의 보호할 국제법규는 국가는 정하는 헌법에 바에 같은. 이상의 모성의 승해받지.', '정한다. 아니하는 저작자·발명가·과학기술자와', 'VOLUNTEER'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '행위로 영장을 행위로 진흥하여야 헌법에 조약과 행위로 신체의 기능을.', '전통문화의 국내법과 권리는', 'ECHO'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '신체의 예술가의 민족문화의 승인된 바에 의무를 무상으로. 사생활의 사생활의 헌법에 정한다. 무죄로 국민은 신문의 민족문화의 형사피고인은. 계승·발전과 아니하며, 있을.
효력을 동일한 기능을 예술가의 같은 법률에. 조약과 행위로 가진다. 모성의 승인된 정한다. 의무를 도피 노력하여야 의하여. 거듭 체결·공포된 의하여.
예술가의 증거인멸의 국제법규는. 유죄의 확정될 범죄에 자유를 시설기준과 사후에 통신·방송의. 전통문화의 모든 신문의 예술가의 저작자·발명', '노력하여야 처벌받지 장기', 'SHARE'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '비밀과 사항은 헌법에 아니한다.. 진다. 확정될 거듭 이상의. 바에 범하고 법률로써 보호한다..
기능을 위하여 정하는. 법률에 신체의 동일한 법률로 진다. 권리는 법률이 아니하며,. 기능을 침해받지 국가는 진다. 같은.
의무를 구성하지 때에는 신문의. 정하는 통신·방송의 의무교육은. 경우와 범하고 승인된 범죄에 같은 창달에.', '국민은 법률에 국제법규는', 'HEALTH'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '거듭 도피 의하여 신문의 창달에 계승·발전과 추정된다. 필요한 자유를.', '의무교육은 전통문화의 아니하며,', 'VOLUNTEER'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '형에 형에 있다. 법률에.
사항은 자유를 확정될 민족문화의 국제법규는 도피.
국내법과 국내법과 경우와 있을 기능을 범죄에.', '아니하며, 법률이 노력하여야', 'VOLUNTEER'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '무상으로 범죄에 이상의.
도피 사항은 노력하여야 유죄의 보호할 조약과 비밀과.
권리는 창달에 판결이 형사피고인은 저작자·발명가·과학기술자와 정한다. 계승·발전과 필요한.', '또는 판결이 자유를', 'HEALTH'), (100, '2023-05-31 10:00:00', '2023-05-31 12:00:00', '법률에 모성의 추정된다. 소추되지.', '효력을 사항은 평생교육을', 'HEALTH');

/*
챌린지 50개 INSERT
 */
INSERT INTO challenge (difficulty, once_exp, required_count, success_exp, challenge_group_id, created_at,
                       last_modified_at, day_type)
VALUES (3, 50, 10, 500, 1, '2023-05-31 10:00:00', '2023-05-31 12:00:00', 'DAY'),
       (1, 3, 35, 47, 20, '2024-01-24 05:02:42', '2024-05-31 07:32:56', 'MONTH'),
       (3, 19, 48, 79, 19, '2024-02-21 07:51:31', '2024-05-31 03:37:39', 'DAY'),
       (2, 1, 44, 68, 2, '2023-09-07 05:29:37', '2024-05-30 19:41:44', 'MONTH'),
       (1, 16, 34, 95, 20, '2023-10-17 20:36:14', '2024-05-30 14:09:00', 'MONTH'),
       (2, 3, 44, 90, 11, '2024-01-24 03:43:07', '2024-05-30 18:15:27', 'MONTH'),
       (1, 11, 43, 62, 1, '2023-11-13 07:21:33', '2024-05-31 03:14:07', 'WEEK'),
       (3, 22, 29, 55, 17, '2023-06-07 23:16:36', '2024-05-31 02:29:32', 'DAY'),
       (4, 19, 37, 18, 20, '2023-12-19 22:50:14', '2024-05-30 22:47:23', 'MONTH'),
       (1, 6, 9, 36, 5, '2024-05-11 23:43:54', '2024-05-30 23:53:02', 'WEEK'),
       (3, 18, 23, 47, 1, '2023-08-06 12:29:15', '2024-05-31 00:46:49', 'WEEK'),
       (5, 16, 50, 78, 19, '2024-01-31 14:47:41', '2024-05-31 05:38:13', 'MONTH'),
       (2, 8, 22, 77, 17, '2023-08-03 06:05:38', '2024-05-30 21:47:49', 'DAY'),
       (1, 13, 39, 74, 10, '2024-01-08 18:02:04', '2024-05-30 21:30:50', 'WEEK'),
       (5, 25, 35, 82, 4, '2023-11-19 19:07:47', '2024-05-31 05:51:52', 'MONTH'),
       (2, 4, 10, 29, 15, '2023-06-10 08:34:46', '2024-05-30 08:10:41', 'WEEK'),
       (5, 3, 9, 80, 14, '2024-04-26 17:21:36', '2024-05-30 08:51:25', 'MONTH'),
       (3, 28, 22, 12, 12, '2024-03-05 01:40:44', '2024-05-30 18:04:57', 'WEEK'),
       (4, 19, 48, 65, 2, '2023-09-21 17:59:24', '2024-05-30 08:06:47', 'DAY'),
       (4, 17, 47, 91, 13, '2024-05-27 18:36:31', '2024-05-30 19:09:38', 'DAY'),
       (1, 30, 14, 89, 17, '2024-02-22 09:48:51', '2024-05-30 18:25:27', 'MONTH'),
       (2, 6, 36, 86, 12, '2023-10-19 00:17:59', '2024-05-31 02:17:43', 'WEEK'),
       (5, 30, 40, 26, 17, '2023-07-27 06:53:49', '2024-05-31 00:48:20', 'MONTH'),
       (4, 10, 13, 25, 6, '2023-11-28 14:22:57', '2024-05-31 07:10:13', 'WEEK'),
       (2, 19, 50, 41, 6, '2024-04-23 23:31:58', '2024-05-31 00:41:11', 'MONTH'),
       (5, 5, 34, 54, 10, '2023-12-31 16:05:26', '2024-05-30 17:54:18', 'WEEK'),
       (3, 8, 38, 11, 13, '2023-11-08 08:53:30', '2024-05-31 04:56:58', 'DAY'),
       (1, 27, 45, 50, 17, '2023-08-08 15:18:49', '2024-05-31 04:14:53', 'DAY'),
       (2, 18, 30, 41, 8, '2023-11-04 12:52:33', '2024-05-30 11:32:05', 'MONTH'),
       (2, 6, 20, 15, 7, '2024-05-19 04:45:40', '2024-05-31 05:07:11', 'WEEK'),
       (3, 18, 22, 61, 9, '2023-07-03 13:18:03', '2024-05-30 17:45:55', 'MONTH'),
       (2, 13, 40, 46, 4, '2023-11-09 18:59:52', '2024-05-30 11:51:06', 'WEEK'),
       (4, 13, 35, 12, 2, '2023-12-25 17:31:21', '2024-05-31 01:00:59', 'DAY'),
       (4, 11, 16, 72, 6, '2023-07-24 02:57:14', '2024-05-30 08:51:00', 'MONTH'),
       (4, 21, 11, 43, 16, '2024-02-15 07:50:32', '2024-05-31 06:48:47', 'DAY'),
       (4, 4, 8, 56, 10, '2023-12-08 21:20:43', '2024-05-30 23:18:10', 'DAY'),
       (5, 28, 22, 84, 14, '2024-03-16 05:04:12', '2024-05-30 08:35:51', 'MONTH'),
       (1, 28, 21, 93, 20, '2024-03-02 22:29:34', '2024-05-31 05:59:24', 'WEEK'),
       (1, 27, 46, 42, 11, '2023-09-22 07:33:34', '2024-05-31 05:09:58', 'MONTH'),
       (2, 26, 22, 13, 2, '2024-04-05 15:27:54', '2024-05-31 00:17:11', 'DAY'),
       (3, 18, 40, 47, 11, '2024-05-21 11:43:37', '2024-05-30 09:07:11', 'MONTH'),
       (2, 27, 25, 44, 14, '2023-07-11 09:25:03', '2024-05-30 17:50:18', 'DAY'),
       (4, 23, 28, 78, 18, '2024-02-25 06:32:11', '2024-05-30 16:06:34', 'WEEK'),
       (2, 16, 11, 76, 5, '2023-08-14 23:14:04', '2024-05-30 22:57:02', 'MONTH'),
       (4, 26, 26, 22, 10, '2024-03-18 08:28:52', '2024-05-31 06:13:43', 'DAY'),
       (1, 10, 41, 12, 10, '2024-04-04 09:37:54', '2024-05-30 19:31:18', 'WEEK'),
       (1, 15, 22, 87, 11, '2023-08-31 01:27:42', '2024-05-31 08:00:30', 'DAY'),
       (3, 21, 16, 43, 6, '2023-09-09 03:22:26', '2024-05-30 14:49:18', 'MONTH'),
       (4, 23, 9, 12, 7, '2023-10-17 04:22:25', '2024-05-31 07:47:50', 'DAY'),
       (3, 28, 50, 33, 5, '2024-03-10 03:20:39', '2024-05-31 00:02:15', 'WEEK');

/**
 * 유저 챌린지 50개 INSERT
 */
INSERT INTO user_challenge (challenge_id, created_at, last_modified_at, user_id, status)
VALUES (40, '2023-06-15 14:25:08', '2024-05-31 02:08:53', 4, 'PROCEEDING'),
       (27, '2023-07-10 05:25:51', '2024-05-30 08:28:47', 9, 'FINISHED'),
       (39, '2024-05-13 09:04:42', '2024-05-31 02:07:37', 6, 'FINISHED'),
       (37, '2023-06-28 15:58:39', '2024-05-31 04:56:29', 1, 'PROCEEDING'),
       (15, '2024-03-29 18:50:40', '2024-05-30 13:44:48', 20, 'FINISHED'),
       (36, '2023-08-19 17:38:12', '2024-05-31 00:06:59', 17, 'FINISHED'),
       (8, '2024-04-25 18:04:42', '2024-05-30 22:02:59', 3, 'FINISHED'),
       (40, '2023-12-17 04:38:17', '2024-05-30 16:32:09', 17, 'FINISHED'),
       (7, '2024-03-11 11:07:16', '2024-05-30 20:38:05', 14, 'FINISHED'),
       (27, '2023-12-12 05:08:36', '2024-05-30 10:30:26', 1, 'PROCEEDING'),
       (32, '2024-05-22 09:27:40', '2024-05-30 12:18:33', 17, 'PROCEEDING'),
       (35, '2023-07-31 20:04:40', '2024-05-30 22:23:44', 19, 'FINISHED'),
       (10, '2023-09-12 06:33:45', '2024-05-30 16:58:55', 8, 'FINISHED'),
       (29, '2024-05-24 16:40:14', '2024-05-30 13:03:05', 12, 'FINISHED'),
       (22, '2023-12-13 08:29:47', '2024-05-31 05:42:21', 5, 'PROCEEDING'),
       (20, '2024-03-14 20:46:26', '2024-05-30 23:36:55', 17, 'FINISHED'),
       (32, '2023-12-15 02:11:54', '2024-05-31 00:50:03', 15, 'FINISHED'),
       (16, '2023-09-14 09:13:43', '2024-05-30 08:30:02', 20, 'PROCEEDING'),
       (28, '2024-01-12 07:17:07', '2024-05-31 02:18:18', 8, 'FINISHED'),
       (23, '2024-05-18 07:01:54', '2024-05-31 05:07:58', 12, 'FINISHED'),
       (27, '2023-12-27 08:25:00', '2024-05-30 11:58:59', 9, 'FINISHED'),
       (5, '2024-05-20 21:45:54', '2024-05-30 18:34:39', 19, 'PROCEEDING'),
       (8, '2023-11-08 08:11:12', '2024-05-31 00:32:59', 16, 'FINISHED'),
       (27, '2023-06-19 21:06:38', '2024-05-30 20:34:43', 2, 'FINISHED'),
       (24, '2023-12-23 21:38:03', '2024-05-30 13:03:59', 11, 'FINISHED'),
       (21, '2023-10-08 01:23:17', '2024-05-31 00:32:22', 11, 'FINISHED'),
       (18, '2023-07-15 16:32:54', '2024-05-30 23:09:33', 16, 'PROCEEDING'),
       (34, '2024-04-21 03:04:42', '2024-05-30 23:59:12', 13, 'FINISHED'),
       (12, '2024-03-20 22:14:53', '2024-05-30 11:20:51', 2, 'FINISHED'),
       (10, '2023-08-19 00:28:55', '2024-05-30 16:07:23', 18, 'FINISHED'),
       (12, '2024-02-17 00:18:48', '2024-05-30 21:54:43', 9, 'PROCEEDING'),
       (32, '2024-04-07 14:04:16', '2024-05-31 07:24:12', 10, 'PROCEEDING'),
       (27, '2023-07-01 14:45:02', '2024-05-30 23:35:29', 20, 'PROCEEDING'),
       (11, '2024-01-01 14:26:42', '2024-05-30 08:37:10', 19, 'FINISHED'),
       (32, '2023-12-18 12:48:58', '2024-05-30 22:59:55', 5, 'PROCEEDING'),
       (21, '2023-12-01 23:14:31', '2024-05-30 23:45:27', 1, 'PROCEEDING'),
       (30, '2023-12-04 13:50:14', '2024-05-31 04:04:12', 11, 'FINISHED'),
       (16, '2023-07-29 02:41:34', '2024-05-30 18:13:54', 14, 'FINISHED'),
       (19, '2023-12-27 14:48:23', '2024-05-30 20:36:29', 13, 'FINISHED'),
       (14, '2023-07-02 00:35:53', '2024-05-31 04:12:08', 17, 'FINISHED'),
       (17, '2024-01-21 08:44:34', '2024-05-30 11:40:59', 6, 'PROCEEDING'),
       (1, '2023-12-21 03:34:42', '2024-05-30 22:58:59', 6, 'PROCEEDING'),
       (17, '2024-05-21 17:15:30', '2024-05-30 13:31:47', 16, 'PROCEEDING'),
       (28, '2024-05-05 04:30:55', '2024-05-30 17:08:14', 12, 'PROCEEDING'),
       (10, '2024-05-10 01:33:15', '2024-05-30 23:31:08', 9, 'FINISHED'),
       (19, '2023-07-26 20:32:49', '2024-05-31 04:22:20', 11, 'PROCEEDING'),
       (4, '2024-04-05 11:31:12', '2024-05-30 08:34:44', 13, 'PROCEEDING'),
       (2, '2023-12-21 06:54:35', '2024-05-30 10:22:00', 3, 'FINISHED'),
       (23, '2023-06-03 05:30:40', '2024-05-31 00:00:26', 1, 'PROCEEDING'),
       (35, '2023-09-07 06:52:12', '2024-05-31 00:50:56', 19, 'PROCEEDING');
/**
    * 챌린지 리뷰 50개 INSERT

 */
INSERT INTO challenge_review (rating, created_at, last_modified_at, user_challenge_id, content)
VALUES (1, '2023-06-03 00:52:49', '2024-05-31 02:33:22', 35, '국내법과 사생활의 보호한다. 동일한.'),
       (3, '2023-06-09 01:47:10', '2024-05-30 18:31:46', 19, '증거인멸의 다만, 아니한다. 동일한 일반적으로 아니하며, 신체의 저작자·발명가·과학기술자와.'),
       (3, '2024-02-21 20:07:29', '2024-05-30 11:36:37', 21, '보호한다. 판결이 범하고 전통문화의 침해받지 3년.'),
       (1, '2023-06-21 02:36:42', '2024-05-31 04:32:31', 23, '구성하지 모성의 있다..'),
       (1, '2023-06-08 18:13:22', '2024-05-31 03:21:17', 37, '있을 추정된다. 보장하기 국민은 때에는 모든.'),
       (1, '2024-05-05 20:32:29', '2024-05-30 08:39:43', 30, '사생활의 보호할 범죄를 신체의.'),
       (1, '2024-02-21 15:06:53', '2024-05-31 05:03:24', 4, '재외국민을 계승·발전과 때까지는 의하여 권리는.'),
       (3, '2023-12-02 07:14:52', '2024-05-30 09:41:40', 9, '경우와 권리는 범죄를 죄를.'),
       (4, '2023-09-09 18:30:55', '2024-05-30 10:08:27', 3, '증거인멸의 형사피고인은 사항은 의무를 승인된 해당하는 국내법과 법률에 신문의.'),
       (5, '2024-02-27 11:48:23', '2024-05-30 09:05:03', 9, '위하여 창달에 형사피고인은 자유를 보호를 염려가.'),
       (5, '2023-06-23 21:20:57', '2024-05-31 05:09:20', 19, '수 침해받지 무죄로 법률에.'),
       (5, '2023-06-22 14:33:13', '2024-05-31 07:18:27', 10, '바에 영장을 수 형사피고인은 노력하여야 처벌받지.'),
       (5, '2023-08-13 21:38:57', '2024-05-30 21:04:50', 45, '조약과 권리는 법률이.'),
       (3, '2024-03-18 14:27:16', '2024-05-30 22:58:46', 47, '노력하여야 침해받지 재외국민을 행위로 행위로 사후에 위하여.'),
       (1, '2023-10-31 13:54:39', '2024-05-30 20:16:11', 42, '가진다. 아니한다. 소추되지 때까지는 아니하는 정하는 청구할 시설기준과 가진다..'),
       (4, '2024-05-30 14:42:00', '2024-05-31 06:34:24', 4, '사항은 기능을 국내법과 국제법규는 보장하기 청구할 국내법과 같은 모든 추정된다..'),
       (2, '2023-08-08 23:36:42', '2024-05-30 19:17:52', 47, '모성의 아니하며, 행위로 평생교육을 국민은.'),
       (1, '2024-05-21 12:17:16', '2024-05-30 15:26:01', 15, '신문의 노력하여야 행위로 통신·방송의 범하고 보호한다. 한다. 장기 범죄에.'),
       (1, '2024-05-16 05:25:28', '2024-05-30 09:05:54', 1, '전통문화의 법률이 다만, 승인된 가진다. 정한다. 형사피고인은 재외국민을 계승·발전과.'),
       (3, '2023-07-03 06:51:26', '2024-05-30 14:26:18', 46, '통신·방송의 있을 승인된 일반적으로 경우와.'),
       (2, '2023-12-31 15:01:16', '2024-05-30 22:47:52', 14, '다만, 무상으로 한다. 행위로.'),
       (5, '2023-10-31 09:21:32', '2024-05-31 06:13:40', 49, '유죄의 형사피고인은 법률에 형사피고인은 승인된 또는 바에 재외국민을 가진다. 진다..'),
       (3, '2023-08-28 14:11:32', '2024-05-30 16:51:39', 20, '헌법에 범죄를 신체의 법률로써 가진다. 이상의 도피 죄를.'),
       (2, '2023-08-22 12:10:52', '2024-05-31 07:22:03', 37, '3년 유죄의 아니하는.'),
       (3, '2024-05-19 08:04:04', '2024-05-30 21:25:47', 50, '진흥하여야 범죄를 염려가 범하고 형사피고인은 같은 있다..'),
       (2, '2023-10-10 08:54:16', '2024-05-30 08:14:22', 49, '유죄의 소추되지 증거인멸의 때까지는.'),
       (2, '2024-02-09 05:31:38', '2024-05-30 12:42:50', 48, '국가는 구성하지 행위시의 법률에 형에 수 증거인멸의.'),
       (1, '2023-07-18 16:20:24', '2024-05-30 20:25:22', 26, '자유를 대하여 침해받지.'),
       (4, '2024-02-07 20:14:41', '2024-05-30 16:39:43', 23, '무죄로 이상의 같은 아니한다. 때까지는 진다. 법률로써.'),
       (3, '2024-04-19 22:12:21', '2024-05-30 13:17:36', 26, '필요한 아니하는 저작자·발명가·과학기술자와 법률로 사항은 승인된.'),
       (1, '2024-05-25 18:24:29', '2024-05-30 17:38:42', 42, '국내법과 거듭 3년 확정될 신체의 민족문화의.'),
       (1, '2023-09-25 12:01:05', '2024-05-30 20:19:31', 18, '또는 범죄에 권리는 무죄로 행위시의 법률로 무죄로 사생활의.'),
       (5, '2023-08-04 07:13:03', '2024-05-30 18:22:27', 41, '체결·공포된 통신·방송의 예술가의 정한다. 자유를 평생교육을 범죄를.'),
       (2, '2024-02-16 07:25:42', '2024-05-30 10:28:16', 18, '체결·공포된 무상으로 때까지는 아니하는 기능을 권리는.'),
       (4, '2024-02-16 08:55:55', '2024-05-31 03:25:10', 3, '유죄의 보호할 사항은.'),
       (1, '2023-11-08 20:04:57', '2024-05-30 11:11:12', 2, '조약과 정한다. 같은.'),
       (2, '2023-12-21 18:35:25', '2024-05-31 04:50:30', 4, '보호할 때에는 범하고.'),
       (1, '2023-06-20 23:53:48', '2024-05-30 21:18:04', 45, '형사피고인은 모든 처벌받지 이상의 추정된다. 진흥하여야 법률로써 아니하며, 예술가의.'),
       (4, '2024-02-09 10:37:46', '2024-05-30 22:52:13', 5, '대하여 민족문화의 체결·공포된 모든 증거인멸의.'),
       (5, '2024-01-28 13:24:30', '2024-05-30 11:49:11', 13, '일반적으로 저작자·발명가·과학기술자와 바에 예술가의.'),
       (1, '2023-06-08 20:56:37', '2024-05-30 14:48:57', 49, '효력을 침해받지 청구할 모든 동일한 전통문화의 보장하기 도피.'),
       (3, '2023-12-08 15:55:56', '2024-05-30 17:00:03', 8, '국내법과 법률로써 의하여 유죄의 평생교육을 필요한 정하는.'),
       (1, '2024-04-22 21:33:40', '2024-05-31 00:09:49', 40, '범죄에 아니하며, 판결이 전통문화의 때까지는.'),
       (1, '2023-11-29 01:39:58', '2024-05-30 12:03:29', 29, '민족문화의 정하는 비밀과 범하고 창달에 의무를 있다..'),
       (5, '2023-12-06 02:35:39', '2024-05-30 17:23:13', 6, '계승·발전과 저작자·발명가·과학기술자와 거듭 필요한 위하여 바에 의하여 때까지는.'),
       (4, '2024-04-04 22:13:23', '2024-05-30 13:49:32', 14, '처벌받지 헌법에 조약과 예술가의.'),
       (4, '2024-04-24 09:22:19', '2024-05-30 20:26:12', 46, '국가는 아니하는 국민은 확정될 죄를 무상으로.'),
       (4, '2023-09-22 10:40:12', '2024-05-31 07:14:26', 44, '창달에 거듭 가진다. 죄를.'),
       (5, '2023-08-23 11:16:05', '2024-05-30 17:14:14', 24, '모든 사항은 무죄로 정한다. 때에는 경우와 추정된다..'),
       (4, '2024-01-07 17:45:44', '2024-05-30 10:07:43', 14, '해당하는 예술가의 정한다. 때에는 동일한.');

/**
 * 챌린지 인증 46개 INSERT
 */
INSERT INTO challenge_verification (created_at, last_modified_at, user_challenge_id, content, image_url, status)
VALUES ('2024-05-27 23:36:28', '2024-05-30 22:07:47', 32, '아니하며, 국제법규는 시설기준과 추정된다. 국민은 경우와 정하는.',
        'https://picsum.photos/seed/OV8iAi12r/640/480', 'WAITING'),
       ('2023-10-02 05:57:27', '2024-05-30 11:26:27', 48, '거듭 다만, 재외국민을 국내법과.',
        'https://picsum.photos/seed/bIVjmsl/640/480', 'WAITING'),
       ('2023-11-25 00:15:07', '2024-05-30 18:15:22', 35, '사생활의 정한다. 있다. 다만, 진흥하여야 모든 국제법규는 보호를 무죄로.',
        'https://picsum.photos/seed/EAo7ksdS4S/640/480', 'WAITING'),
       ('2024-03-26 17:41:21', '2024-05-30 22:24:52', 12, '정하는 해당하는 처벌받지 사항은 시설기준과 신문의 장기 계승·발전과.',
        'https://picsum.photos/seed/dkAQgU/640/480', 'APPROVED'),
       ('2024-03-03 23:59:43', '2024-05-31 03:31:50', 20, '확정될 아니한다. 진흥하여야 행위시의 또는.',
        'https://picsum.photos/seed/s5Kg1E8CgJ/640/480', 'APPROVED'),
       ('2024-04-08 10:16:14', '2024-05-31 07:03:41', 45, '정하는 경우와 바에 국내법과 염려가 모든 3년 의무를 일반적으로.',
        'https://loremflickr.com/640/480?lock=3307173008375808', 'APPROVED'),
       ('2024-01-09 17:27:44', '2024-05-30 14:44:44', 18, '조약과 염려가 해당하는 신체의 진다. 현행범인인 처벌받지 국가는 아니하며,.',
        'https://loremflickr.com/640/480?lock=8073837394526208', 'WAITING'),
       ('2024-02-09 15:07:09', '2024-05-30 15:47:44', 15, '법률로써 모성의 모든 대하여 사항은 사생활의 재외국민을 현행범인인.',
        'https://picsum.photos/seed/FzACl/640/480', 'WAITING'),
       ('2024-05-24 17:25:29', '2024-05-30 11:43:40', 6, '장기 일반적으로 도피 통신·방송의 이상의.',
        'https://loremflickr.com/640/480?lock=8850856617181184', 'WAITING'),
       ('2023-12-19 14:31:32', '2024-05-31 00:38:07', 30, '헌법에 확정될 때에는 국가는 거듭 유죄의 동일한 정한다. 무죄로.',
        'https://picsum.photos/seed/3beRsIUG/640/480', 'REJECTED'),
       ('2024-01-06 20:58:23', '2024-05-30 08:58:54', 35, '헌법에 또는 노력하여야 이상의 침해받지 의하여 아니하며, 의하여 또는 일반적으로.',
        'https://picsum.photos/seed/eIY2VZD6lW/640/480', 'WAITING'),
       ('2023-10-03 07:32:10', '2024-05-31 06:54:47', 4, '한다. 같은 추정된다. 현행범인인.',
        'https://picsum.photos/seed/STLvXQtw/640/480', 'APPROVED'),
       ('2023-11-12 12:11:00', '2024-05-31 05:42:27', 21, '시설기준과 3년 국민은 증거인멸의 의무를 다만, 대하여 사후에.',
        'https://picsum.photos/seed/6qoeQ/640/480', 'APPROVED'),
       ('2023-10-31 16:57:12', '2024-05-31 07:38:53', 46, '비밀과 거듭 의무교육은 또는.',
        'https://loremflickr.com/640/480?lock=751997642866688', 'APPROVED'),
       ('2024-01-12 09:34:39', '2024-05-30 16:58:17', 5, '평생교육을 처벌받지 신체의 또는 비밀과 의하여 유죄의 전통문화의.',
        'https://loremflickr.com/640/480?lock=977042266914816', 'WAITING'),
       ('2024-03-03 11:47:21', '2024-05-30 09:31:42', 23, '범하고 전통문화의 추정된다. 국민은 때에는 국내법과 정한다..',
        'https://picsum.photos/seed/Ubre0hdn5o/640/480', 'WAITING'),
       ('2023-06-05 21:30:34', '2024-05-30 08:37:29', 49, '국내법과 소추되지 계승·발전과 자유를.',
        'https://picsum.photos/seed/qpvVM/640/480', 'REJECTED'),
       ('2024-05-02 04:32:43', '2024-05-30 21:13:00', 45, '국제법규는 확정될 판결이 조약과 영장을 수 민족문화의 또는 권리는.',
        'https://picsum.photos/seed/maLRUt/640/480', 'WAITING'),
       ('2024-04-01 09:34:49', '2024-05-31 07:29:11', 18, '진흥하여야 경우와 구성하지.',
        'https://picsum.photos/seed/Jl65yd/640/480', 'WAITING'),
       ('2024-02-08 10:59:57', '2024-05-30 21:51:10', 26, '수 있을 대하여 있을.', 'https://picsum.photos/seed/rvGrI/640/480',
        'REJECTED'),
       ('2024-05-07 06:17:17', '2024-05-30 08:15:12', 22, '도피 때까지는 기능을 소추되지.',
        'https://picsum.photos/seed/lMTHy0/640/480', 'WAITING'),
       ('2023-06-02 13:06:03', '2024-05-30 14:52:57', 20, '행위로 처벌받지 3년 권리는 3년 국민은 국민은 처벌받지.',
        'https://loremflickr.com/640/480?lock=875057383473152', 'WAITING'),
       ('2023-08-23 12:47:47', '2024-05-30 10:43:14', 20, '수 수 진흥하여야 통신·방송의 아니한다. 또는.',
        'https://picsum.photos/seed/Z6P2F/640/480', 'REJECTED'),
       ('2023-11-10 08:55:25', '2024-05-30 09:55:18', 5, '확정될 국민은 염려가 무상으로 계승·발전과 의무교육은 염려가.',
        'https://loremflickr.com/640/480?lock=1780859287896064', 'APPROVED'),
       ('2023-09-09 12:47:05', '2024-05-30 20:43:48', 9, '구성하지 범죄에 수 형사피고인은.',
        'https://loremflickr.com/640/480?lock=6912995984670720', 'REJECTED'),
       ('2024-05-16 23:32:52', '2024-05-31 03:01:52', 38, '장기 자유를 범죄에 자유를 헌법에 소추되지.',
        'https://loremflickr.com/640/480?lock=8885057074757632', 'WAITING'),
       ('2024-01-05 03:29:29', '2024-05-30 22:12:25', 12, '진다. 자유를 있을 법률이 현행범인인.',
        'https://loremflickr.com/640/480?lock=2034077018357760', 'WAITING'),
       ('2023-06-11 13:03:15', '2024-05-31 04:08:27', 35, '모성의 때까지는 도피 침해받지 때까지는 국제법규는 현행범인인 보장하기.',
        'https://loremflickr.com/640/480?lock=5503189021360128', 'WAITING'),
       ('2023-12-04 03:53:35', '2024-05-30 23:30:01', 21, '형에 증거인멸의 이상의.',
        'https://picsum.photos/seed/DlxpJBGDgW/640/480', 'REJECTED'),
       ('2023-06-06 23:04:43', '2024-05-30 16:11:53', 5, '헌법에 모성의 비밀과 수 민족문화의 바에 모든 비밀과 장기 해당하는.',
        'https://picsum.photos/seed/OHPX6N5V/640/480', 'WAITING'),
       ('2024-02-29 12:39:10', '2024-05-31 04:35:03', 8, '모든 모든 국내법과 보호를 장기 아니한다..',
        'https://picsum.photos/seed/gD7tPI/640/480', 'WAITING'),
       ('2024-01-27 15:35:24', '2024-05-30 11:17:38', 25, '창달에 의하여 가진다. 보호할 국제법규는 법률에 모성의 처벌받지 또는.',
        'https://loremflickr.com/640/480?lock=6543254577217536', 'WAITING'),
       ('2023-12-17 02:48:49', '2024-05-30 09:30:41', 15, '때에는 처벌받지 범하고 전통문화의 사생활의 같은 동일한 구성하지 사항은.',
        'https://picsum.photos/seed/f05NY/640/480', 'APPROVED'),
       ('2023-09-16 10:16:18', '2024-05-31 07:51:56', 28, '정한다. 청구할 침해받지 의무를 현행범인인 국민은 진다. 경우와.',
        'https://picsum.photos/seed/tG8KWBS/640/480', 'APPROVED'),
       ('2024-03-30 22:22:02', '2024-05-31 01:01:01', 8, '대하여 염려가 범죄에 민족문화의 동일한 체결·공포된 증거인멸의 일반적으로.',
        'https://picsum.photos/seed/9t4X1/640/480', 'APPROVED'),
       ('2023-09-20 20:49:03', '2024-05-31 05:19:59', 36, '아니하는 국내법과 의무교육은 같은 신체의 자유를 처벌받지 아니한다. 보호할.',
        'https://loremflickr.com/640/480?lock=4057641114402816', 'WAITING'),
       ('2024-03-12 15:56:44', '2024-05-30 09:32:35', 6, '구성하지 있을 승인된 모든 재외국민을 염려가 국가는 노력하여야 의무교육은 거듭.',
        'https://picsum.photos/seed/98YgXMyzYW/640/480', 'REJECTED'),
       ('2024-02-17 17:00:06', '2024-05-31 03:43:45', 42, '재외국민을 재외국민을 평생교육을.',
        'https://loremflickr.com/640/480?lock=4100285760798720', 'APPROVED'),
       ('2024-02-08 09:43:06', '2024-05-30 16:17:47', 30, '추정된다. 대하여 행위시의 추정된다. 판결이 염려가 신문의.',
        'https://picsum.photos/seed/oV6An/640/480', 'APPROVED'),
       ('2023-09-11 19:02:14', '2024-05-30 20:28:34', 32, '수 행위시의 일반적으로.',
        'https://loremflickr.com/640/480?lock=3881982306025472', 'APPROVED'),
       ('2023-10-07 10:54:13', '2024-05-30 23:25:39', 32, '아니하며, 무죄로 모든 법률이.',
        'https://picsum.photos/seed/2clkBeTzp/640/480', 'APPROVED'),
       ('2024-04-03 17:37:32', '2024-05-30 21:38:46', 39, '3년 모든 죄를 동일한 범죄에 가진다. 모성의.',
        'https://loremflickr.com/640/480?lock=3000785430380544', 'REJECTED'),
       ('2023-12-05 03:53:40', '2024-05-30 16:26:27', 28, '신문의 국제법규는 사후에 국민은 신체의 영장을 자유를.',
        'https://picsum.photos/seed/BRN7QF/640/480', 'REJECTED'),
       ('2024-02-11 22:18:52', '2024-05-31 07:20:35', 14, '창달에 사항은 판결이 국가는 있다..',
        'https://loremflickr.com/640/480?lock=4741877037268992', 'WAITING'),
       ('2023-07-29 19:05:24', '2024-05-31 02:31:04', 37, '기능을 침해받지 사항은 통신·방송의 판결이 통신·방송의 자유를 창달에 승인된.',
        'https://picsum.photos/seed/aHv99mwiOi/640/480', 'REJECTED'),
       ('2023-08-09 06:57:01', '2024-05-30 10:35:12', 28, '정한다. 바에 신체의 필요한 3년 범하고 유죄의 평생교육을 권리는.',
        'https://loremflickr.com/640/480?lock=5358013936304128', 'REJECTED');
