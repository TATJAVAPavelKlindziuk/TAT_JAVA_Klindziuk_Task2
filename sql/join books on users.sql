SELECT * FROM library.books
INNER JOIN library.subscriptions ON library.books.id = library.subscriptions.sb_book
INNER JOIN library.users ON library.users.id = library.subscriptions.sb_user
WHERE library.users.id = 1; 