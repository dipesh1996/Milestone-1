# Milestone-1
It is a Milestone 1 for my Subject CECS 529: Search Engine Technology.

Overview

In this project milestone, you will piece together and extend many of the search engine features you have already programmed in this class. You may work in teams of up to 3 people, but as you will see, more people
in a group will necessitate additional work. You will program an application to index a directory of files using a positional inverted index. You will
ask the user for the name of the directory to index, and then load all the documents in that directory and construct your index with their contents. You will then process the user's Boolean search queries on the index you constructed. This firstrst milestone will use a text-based interface as in your homework assignments. When processing a
query, you must display the name of each document that matches the request, and then allow the user to (optionally) select a document from the result list. If the user selects a document, its original text (not
processed, stemmed, etc.) should be displayed.


Here is a brief list of things implemented: 
1. Build a positional inverted index over a user-specifed directory of text files.
2. Process tokens from files with special rules; and use similar rules for user queries.
3. Finish the Boolean query processing module so you can handle queries from the user and merge postings lists for the query.
4. Support phrase queries with quotation marks via the positional index.

1. Category A:
(a) NOT queries
(b) Expanded query parser

2. Category B:
(a) NEAR/K operator
(b) Biword index
(c) GUI
(d) Unit tests
