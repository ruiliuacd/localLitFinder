# localLitFinder
Use a search engine core (lucene) to find local literatures according to your key words

from /localLitFinder/src/com/gui/test.java to start APP or use the release jar(double clicks).

Old learning records but the APP are still useful. When you stored a huge amount of pdf literatures in your disc that your ever read and sometimes you can't remember the excactly file you want, you can use this APP to search the literatures with the keyword in your local disk.
easy to use:
1. Select '索引目录'(index directory) to store the idx files that can be used anytime after it's build.
2. Select '文件目录'(files directory) where all your literature files are stored, whether directly or in subdirectories of any depth. Currently only pdf file are recognized while other types of files do not influnece the search/index.
3. Click '开始建立索引文件'(build the index) and wait for a while.
4. Any time you'd like to search a keyword, select the '索引目录'(index directory) then type a keyword in the text line above the button '开始搜索'（srearch）. Only one lowercase keyword and without special character are available.
5. Results will be list under the button in the big text area.


Just for fun, I have forgot the code otherwise some improvement can be made.
'corefunc' package are some other other exploration about the token and natural language analysis.