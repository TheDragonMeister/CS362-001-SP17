/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

    private boolean printStatus = false;
    private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.


    public UrlValidatorTest(String testName) {
        super(testName);
    }



    public void testManualTest()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //valid
        System.out.println(urlVal.isValid("http://www.amazon.com"));
        System.out.println(urlVal.isValid("http://www.google.com"));
        System.out.println(urlVal.isValid("http:////www.google.com"));
        System.out.println(urlVal.isValid("http://www.github.com"));
        System.out.println(urlVal.isValid("http://www.oregonstate.edu"));
        System.out.println(urlVal.isValid("http://www.youtube.com"));
        System.out.println(urlVal.isValid("http://www.bbc.com"));

        //invalid
        System.out.println(urlVal.isValid("http://www.google.edu"));
        System.out.println(urlVal.isValid("abc://www.google.com"));
        System.out.println(urlVal.isValid("http://wwwww.google.com"));
        System.out.println(urlVal.isValid("http://www.google.cccom"));
        System.out.println(urlVal.isValid("http:.google.com"));
        System.out.println(urlVal.isValid("http://www.google."));
        System.out.println(urlVal.isValid("httpwww.google.com"));
        System.out.println(urlVal.isValid(""));

    }

    //test valid inputs
    public void testYourFirstPartition()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //Valid urls
        System.out.println(urlVal.isValid("http://www.amazon.com"));
        System.out.println(urlVal.isValid("http://www.oregonstate.edu"));
        System.out.println(urlVal.isValid("http://www.animefreak.tv/book"));
        System.out.println(urlVal.isValid("https://www.wikipedia.org/"));
        System.out.println(urlVal.isValid(" http://europa.eu/"));
        System.out.println(urlVal.isValid("http://255.255.255.255"));
    }

    //test invalid inputs
    public void testYourSecondPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //bad urls
        System.out.println(urlVal.isValid("abcde://www.amazon.com"));
        System.out.println(urlVal.isValid("habcde://www.amazon.com"));
        System.out.println(urlVal.isValid("abcde://www.oregonstate.edu"));
        System.out.println(urlVal.isValid("abcde://www.amazon.com:abcde"));
        System.out.println(urlVal.isValid("https://abcde"));
        System.out.println(urlVal.isValid("http:/www.animefreak.tv/abc/book/"));
        System.out.println(urlVal.isValid("http://1.1.1.1.1"));
        System.out.println(urlVal.isValid("http://www.google.com:-888"));
        System.out.println(urlVal.isValid("http://300000.3000000.3000000.30000000"));
        System.out.println(urlVal.isValid("http://www.google.com:-888"));
    }

    public void testIsValid() {
        String[] prefix = {"http", "http:", "http://", "://", "htt://", "https://", "human://"};
        String[] name = {"www.facebook", "www.reddit", "www.youtube", "banana", "1.2.3.4", "60.98.34.26"};
        String[] suffix = {".com", ".edu", ".net", ".aaa", ".hello", ".uk", ".tv/book", ".eu", ".net", "", "."};
        String[] path = {"/56/666//", "/", ".", "/abcde/abc", "/abcd./efghi()", "/[][][]", ""};



        //checks all random inputs from the above list
        for(int i = 0;i<10000;i++)
        {
            UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            int pref = (int)(Math.random()*prefix.length);
            int webName = (int)(Math.random()*name.length);
            int suf = (int)(Math.random()*suffix.length);
            int pat = (int)(Math.random()*path.length);
            String testURL = prefix[pref] + name[webName] + suffix[suf] + path[pat];
            System.out.println("" + testURL + "  " + urlVal.isValid(testURL) + "");
        }

        //has a correct preffix
        for(int i = 0;i<100;i++)
        {
            UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            int webName = (int)(Math.random()*name.length);
            int suf = (int)(Math.random()*suffix.length);
            int pat = (int)(Math.random()*path.length);
            String testURL = "http://" + name[webName] + suffix[suf] + path[pat];
            System.out.println("" + testURL + "  " + urlVal.isValid(testURL) + "");
        }

        //has a correct webname
        for (int i = 0; i < 100; i++) {
            UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            int pref = (int)(Math.random()*prefix.length);
            int suf = (int)(Math.random()*suffix.length);
            int pat = (int)(Math.random()*path.length);
            String testURL = prefix[pref] + "www.google" + suffix[suf] + path[pat];
            System.out.println("" + testURL + "  " + urlVal.isValid(testURL) + "");
        }

        //has a correct suffix
        for(int i = 0;i<100;i++)
        {
            UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            int pref = (int)(Math.random()*prefix.length);
            int webName = (int)(Math.random()*name.length);
            int pat = (int)(Math.random()*path.length);
            String testURL = prefix[pref] + name[webName] + ".com" + path[pat];
            System.out.println("" + testURL + "  " + urlVal.isValid(testURL) + "");
        }

        //has a correcct path
        for(int i = 0;i<100;i++)
        {
            UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            int pref = (int)(Math.random()*prefix.length);
            int webName = (int)(Math.random()*name.length);
            int suf = (int)(Math.random()*suffix.length);
            String testURL = prefix[pref] + name[webName] + suffix[suf] + "/";
            System.out.println("" + testURL + "  " + urlVal.isValid(testURL) + "");
        }

    }

}
