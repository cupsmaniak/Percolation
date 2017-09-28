/******************************************************************************
 *  Name: Wurood Mandawi 
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Operating system:
 *  Compiler:
 *  Text editor / IDE: BlueJ
 *
 *  Have you taken (part of) this course before: No
 *  Have you taken (part of) the Coursera course Algorithm, Part I: Yes
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
I set a virtual top to link it to the top row then set a virtual bottom to check if there is a 
path from the top to the bottom(percolates?). then I unioned the top and the botttom with one 
weighted quick union and I unioned the the top only with another to get ride of backwash



/******************************************************************************
 *  Using Percolation with QuickFindUF.java,  fill in the table below such that 
 *  the N values are multiples of each other.

 *  Give a formula (using tilde notation) for the running time (in seconds) of 
 *  PercolationStats.java as a function of both N and T. Be sure to give both 
 *  the coefficient and exponent of the leading term. Your coefficients should 
 *  be based on empirical data and rounded to two significant digits, such as 
 *  5.3*10^-8 * N^5.0 T^1.5.
 *****************************************************************************/

(keep T constant)

 N          time (seconds)
------------------------------
1000		8.051
100		0.051
50		0.021
30		0.019
2556		75.731


(keep N constant)

 T          time (seconds)
------------------------------
30		0.187
50		0.284
1000		5.45
150		0.847
2000		11.018


running time as a function of N and T:  ~ 


/******************************************************************************
 *  Repeat the previous question, but use WeightedQuickUnionUF.java.
 *****************************************************************************/

(keep T constant)

 N          time (seconds)
------------------------------
...
...
...
...
...


(keep N constant)

 T          time (seconds)
------------------------------
...
...
...
...
...


running time as a function of N and T:  ~ 

/**********************************************************************
 *  How much memory (in bytes) does a Percolation object use to store
 *  an N-by-N grid? Use the 64-bit memory cost model from Section 1.4
 *  of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/

4N^2 + 18N + 80









/******************************************************************************
 *  After reading the course collaboration policy, answer the
 *  following short quiz. This counts for a portion of your grade.
 *  Write down the answers in the space below.
 *****************************************************************************/
1. A
2. C
3. D

1. How much help can you give a fellow student taking COS 226?
(a) None. Only the preceptors and lab TAs can help.
(b) You can discuss ideas and concepts but students can get help
    debugging their code only from a preceptor, lab TA, or
    student who has already passed COS 226.
(c) You can help a student by discussing ideas, selecting data
    structures, and debugging their code.
(d) You can help a student by emailing him/her your code.

2. What are the rules when partnering?
 (a) You and your partner must both be present while writing code.
     But after that only one person needs to do the analysis.
 (b) You and your partner must both be present while writing code
     and during the analysis, but, after that, only one person
     needs to be present while submitting the code and the
     readme.
 (c) You and your partner must both be present while writing code,
     during the analysis, and while submitting the code and the
     readme. Failure to do so is a violation of the course
     collaboration policy.

3. For any programming assignment, I am permitted to use code that
   I found on a website other than the COS 226 or algs4 website
   (e.g., on GitHub or StackOverflow):
 (a) Only when the online code was written by a person who does not
     and did not go to Princeton.
 (b) Only when the online code implemented different assignment
     specifications than the ones I'm currently working on.
 (c) Always, because online code is available to everyone.
 (d) Never, because such websites are an impermissible "outside 
     source".
 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

N/A


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Josh helped me with figuring out the idea of a virtual top and bottom.
Jiri and Prof. Li Han helped me with my connect method.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
I had a problem with compiling the Visualizers. Then I figured out that I need 
to download the new algs4.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
