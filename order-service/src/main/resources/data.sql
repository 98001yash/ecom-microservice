

INSERT INTO orders (total_price, order_status) VALUES
                                                   (100.50, 'PENDING'),
                                                   (250.00, 'CONFIRMED'),
                                                   (500.75, 'DELIVERED'),
                                                   (75.20, 'CANCELLED'),
                                                   (150.00, 'PENDING'),
                                                   (320.30, 'CONFIRMED'),
                                                   (410.99, 'DELIVERED'),
                                                   (90.50, 'CANCELLED'),
                                                   (200.10, 'PENDING'),
                                                   (350.45, 'CONFIRMED'),
                                                   (425.00, 'DELIVERED'),
                                                   (115.75, 'CANCELLED'),
                                                   (180.80, 'PENDING'),
                                                   (275.65, 'CONFIRMED'),
                                                   (495.00, 'DELIVERED'),
                                                   (65.99, 'CANCELLED'),
                                                   (240.10, 'PENDING'),
                                                   (310.25, 'CONFIRMED'),
                                                   (460.00, 'DELIVERED'),
                                                   (99.95, 'CANCELLED');


INSERT INTO order_item (order_id, product_id, quantity) VALUES
                                                            (1, 101, 2),
                                                            (1, 102, 1),
                                                            (2, 103, 3),
                                                            (2, 101, 1),
                                                            (3, 104, 2),
                                                            (4, 105, 1),
                                                            (5, 106, 2),
                                                            (5, 107, 1),
                                                            (6, 108, 4),
                                                            (7, 109, 2),
                                                            (8, 110, 1),
                                                            (9, 101, 2),
                                                            (10, 102, 3),
                                                            (11, 103, 1),
                                                            (12, 104, 2),
                                                            (13, 105, 1),
                                                            (14, 106, 2),
                                                            (15, 107, 3),
                                                            (16, 108, 1),
                                                            (17, 109, 2);

