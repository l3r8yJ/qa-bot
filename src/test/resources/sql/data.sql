INSERT INTO categories_storage.categories(id, category_name) VALUES (102, 'Test category');

INSERT INTO questions_storage.questions(id, category_id, question_text, question_answer)
VALUES (10, 102, 'Test text', 'Test answer');
