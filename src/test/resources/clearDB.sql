DELETE FROM autor WHERE EXISTS (SELECT 1 FROM autor);