README

For more detail about how each of the questions was answered, please see the pdf document that was submitted with this project. 

This project contains a total of 57 *.java files. However, not all of them were used to answer questions. Many were used to test certain
methods of analyzing the data or checking how the data was formatted so it could be processed. A files are from Map/Reduce runs that worked,
but I decided to try a different approach to the problem. I will only provide detail on those that were used directly to answer the six
questions that were assigned. If the grader has additional questions about any file, I am available to answer those questions at any time or
during the interview portion of the grading. 

Each Map/Reduce run in this project is organized with a Mapper#.java, Reducer#.java, and Job#.java. The numbers indicate Mappers, Reducers, and 
Jobs that were run together. In the discussion below, the numbers correspond the Mapper, Reducer, Job that was run. For example, "2:" corresponds to
Mapper2.java, Reducer2.java, and Job2.java. Again for more detail on how each question was answered, please consult the companion pdf file. 


Question 1
1: run on shared cluster to get count monitors
2: run on local to count monitor sites per state

Answer to Q1: California has the most sites. 

Question 2
3: Utility used to test contents of file. Rewritten several times. Ex: Get units of measure for any needed conversions for next run (all parts per billion)
19: Calculates average SO2 all West Coast states. 

	West Coast average: 2.2351982149709273

18: Calculates mean of all East Coast states' SO2 levels

	East Coast average: 6.117756647882807 parts per billion

Answer to Q2: East Coast has higher mean levels of SO2. 

Question 3
8: Utility used to test contents of file
9: Calculates total measured values and divides by number of entries for each

Answer to Question 3: 16:00 GMT with an average of: 3.5693108814262833

Question 4
10: Utility used to test contents of file
11: Calculate average for each year

Answer to Q4: There has been a change. There has been a steady downward trend in mean SO2 levels. 

Question 5
12: Utility to check contents of data
12b/c: (b/c is the file on shared cluster) used to check units for any conversions - only in Fahrenheit.  
13: computes average temperature for each state in June, July, and August individually.
14: computes average temperature for each state for all 3 three months. Done on local cluster.
15: Sorts the data from 14 by flipping the keys and values. Done on local cluster. 

Answer to Q5:
		
	Top 10 Hottest States (excludes territories such as Puerto Rico and US Virgin Islands):
		MEAN TEMP			CODE	NAME
		78.84453787459675	45 		South Carolina
		79.81856070505921	35		New Mexico
		80.15545803279288	40		Oklahoma
		80.9789377373138	05		Arkansas
		81.10437160270266	22		Louisiana
		81.10571512780996	12		Florida
		81.72435798328246	28		Mississippi
		82.92867652360648	32		Nevada
		83.19399969642159	48		Texas
		85.23862610663072	04		Arizona
		



Question 6:
16: Computes the average SO2 level for the 10 states in Question 5. 

Answer to Question 6:

	Mean SO2 level for the 10 hottest staes founds in Question 6:
		Name			CODE	MEAN SO2 LEVEL
		Arizona			04		6.192774798042817
		Arkansas		05		2.611612607161026
		Florida			12		2.7050180516201516
		Louisiana		22		3.468926172349634
		Mississippi		28		3.06144264949484
		Nevada			32		0.699896678091623
		New Mexico		35		3.4224884140562173
		Oklahoma		40		4.07051929375138
		South Carolina	45		1.4342059655461221
		Texas			48		2.737068367687307




