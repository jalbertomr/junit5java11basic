# JUnit 5 Write unit test with

Laboratory from https://www.vogella.com/tutorials/JUnit/article.html

Exercise using a data modeling from Lord Of the Rings. 

#### Points of JUnit 5 treated

- @Test to define a JUnit procedure


- JUnit test class naming conventions.
       
    **/Test*.java
    **/*Test.java
    **/*Tests.java
    **/*TestCase.java

- location of test
  
    src/main/java - java classes
    src/test/java - test classes
  
- Static Imports

    import static org.junit.jupiter.api.Assertions.assertEquals;
    ...
  
- Assertions and Assumptions
  
    org.junit.jupiter.api.Assertions.*
    assertEquals
    assertTrue
    assertFalse
    assertNull
    assertNotNull
    assertThrows
    ...
  
- Testing grouping assertions with assertAll

    @Test
    void groupedAssertions() {
	   assertAll("Name of Grouped test",
	     () -> assertEquals("espected_Value", objectA.getProperty()),
	     () -> assertEquals("espected_Value", objectA.getProperty())
	  );  
	 }  	
   	 
- Defining timeout in your tests

    import static java.time.Duration.ofSeconds;

	@Test
	void ensureProcTakesNoMore3SecAndWaitForProcEnd(){
	   Assertions.assertTimeout(ofSeconds(3), () -> service.proc());
	}

  Test timeout with result
  
    @Test
    void ensureProcTakesNoMore3SecAndWaitForProcEnd() {
      Boolean result = Assertions.assertTimeout(ofSeconds(3), () -> { service.proc(); });
      Assertions.assertTrue(result);
    }  

  Test timeout with result and NO wait for proc to end
                 
     Assertions.assertTimeoutPreemptive( ofSeconds(3), () -> service.procMoreThan3Sec() ); 

- @Disable To disable test   	 


- Dynamic and parameterized tests

  @TestFactory
  
  (@BeforeEach, @AfterEach are not called in dynamic tests)
  
  
- Parameterized Test

  @MethodSource
  
- Data Sources

  @ValueSource( ints = { 1, 2, 3})
  
  @EnumSource(value = Months.class, names = {"MONDAY","THUESDAY"})
  
  @MethodSource( names = "getDataForTest")
  
  @CsvSource({"foo, 1" , "'bar, lar', 34"})    
  
- Argument Conversion, @ConvertWith

  JUnit tries to convert the source string to match the requered arguments, or implemente ArgumentConverter to customize convertion.

  
- Nested Tests


- Test execution order


- @TempDir to create temporary files and paths


- Test Suites

  