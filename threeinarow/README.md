Author - Ritwik Bagga
# Row Games
This is a basic Java implementation of the Three in a Row game and TicTacTo game strictly following MVC design pattern.

### How to build and test (from Terminal):

1. Make sure that you have Apache Ant installed. Run each ant command in the threeinarow folder, which contains the `build.xml` build file.

2. Run `ant document` to generate the javadoc (a hypertext description) for all of the java classes. Generated hypertext description will be in the `jdoc` folder. Open the `index.html` file. 

3. Run `ant compile` to compile all of the java classes. Compiled classes will be in the `bin` folder.

4. Run `ant test` to run all unit tests.

### How to run (from Terminal):

1. After building the project (i.e., running `ant`), run the following command in the threeinarow folder:
   `java -cp bin RowGameApp`

2. You will be prompted to by stdout to choose what game you want to play. 
3. press 1 for “Three in a Row” and press 2 for “Tic Tac To”, then press enter. 

### How to clean up (from Terminal):

1. Run `ant clean` to clean the project (i.e., delete all generated files).
