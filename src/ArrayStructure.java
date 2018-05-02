
public class ArrayStructure {

  private int[] theArray = new int[50];
  private int arraySize = 10;

  public void generatedRAndomArray() {
    for (int i = 0; i <arraySize ; i++) {
      theArray[i] = (int) (Math.random() * 10) + 10;
    }
  }

  public int getValueIndex(int index) {
    if (index < arraySize) {

      return theArray[index];
    }
    return 0;
  }

  public boolean doesArrayContainThisValue(int searchValue) {
    boolean valueInArray = false;
    for (int i = 0; i < arraySize; i++) {
      if (theArray[i] == searchValue) {
        valueInArray = true;
      }
    }
    return valueInArray;
  }

  public void deleteIndex(int index) {
    if (index < arraySize) {
      for (int i = index; i < arraySize - 1; i++) {
        theArray[i] = theArray[i + 1];
      }
      arraySize--;
    }
  }

  public void insertValue(int value) {
    if (arraySize < 50) {
      theArray[arraySize] = value;
      arraySize++;
    }
  }

  public String linearSearchForValue(int value) {

    boolean valueInArray = false;
    String indexWithValue = "";
    System.out.println("The value was found in the Following: ");

    for (int i = 0; i < arraySize; i++) {
      if (theArray[i] == value) {
        valueInArray = true;
        System.out.println(i + " ");
        indexWithValue += i + " ";
      }
      printHorzArray(i, -1);
    }
    if (!valueInArray) {
      indexWithValue = "None";
      System.out.println(indexWithValue);
    }
    System.out.println();
    return indexWithValue;
  }

  public void printArray() {
    System.out.println("---------");
    for (int i = 0; i < arraySize; i++) {
      System.out.println(i + " "+ theArray[i]);
      System.out.println("---------");

    }
  }

  public void bubbleSort() {
    for (int i = arraySize - 1; i > 0; i--) {
      for (int j = 0; j <i ; j++) {
        if (theArray[j] > theArray[j+1]) {
          swapValues(j, j + 1);
        }
        printHorzArray(i, j);
      }
    }
  }

  private void swapValues(int indexOne, int indexTwo) {
    int temp = theArray[indexOne];
    theArray[indexOne] = theArray[indexTwo];
    theArray[indexTwo] = temp;


  }

  public void binarySearchForValue(int value) {
    int lowIndex = 0;
    int highIndex = arraySize - 1;
    while (lowIndex <= highIndex) {
      int middleIndex = (highIndex + lowIndex) / 2;
      if (theArray[middleIndex] < value) lowIndex = middleIndex;
      else if (theArray[middleIndex] > value) {
        highIndex = middleIndex;
      } else {
        System.out.println("\nFound a Match for " + value + "at Index " + middleIndex);
        break;
      }
      printHorzArray(middleIndex, -1);
    }
  }

  public void selectionSort() {
    for (int i = 0; i < arraySize; i++) {
      int minimum = i;
      for (int j = i; j < arraySize; j++) {
        if (theArray[minimum] > theArray[j]) {
          minimum = j;
        }
      }
      swapValues(i, minimum);
      printHorzArray(i, -1);
    }
  }

  public void insertionSort() {
    for (int i = 0; i < arraySize; i++) {
      int j = i;
      int toInsert = theArray[i];
      while ((j > 0) && (theArray[j - 1] > toInsert)) {
        theArray[j] = theArray[j - 1];
        j--;
        printHorzArray(i, j);

      }
      theArray[j] = toInsert;
      printHorzArray(i, j);
      System.out.println("\nArray[i] = " + theArray[i]+ "Array[j] = " + theArray[j]+"toInsert = " + toInsert);
      }
  }


  public void printHorzArray(int i, int j){

    for(int n = 0; n < 51; n++)System.out.print("-");

    System.out.println();

    for(int n = 0; n < arraySize; n++){

      System.out.print("| " + n + "  ");

    }

    System.out.println("|");

    for(int n = 0; n < 51; n++)System.out.print("-");

    System.out.println();

    for(int n = 0; n < arraySize; n++){

      System.out.print("| " + theArray[n] + " ");

    }

    System.out.println("|");

    for(int n = 0; n < 51; n++)System.out.print("-");

    System.out.println();

    // END OF FIRST PART


    // ADDED FOR BUBBLE SORT

    if(j != -1){

      // ADD THE +2 TO FIX SPACING

      for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");

      System.out.print(j);

    }


    // THEN ADD THIS CODE

    if(i != -1){

      // ADD THE -1 TO FIX SPACING

      for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");

      System.out.print(i);

    }

    System.out.println();

  }



  public static void main(String[] args) {
    ArrayStructure arrayStructure = new ArrayStructure();
    arrayStructure.generatedRAndomArray();
   /* arrayStructure.printArray();
    System.out.println(arrayStructure.getValueIndex(13));
    System.out.println(arrayStructure.doesArrayContainThisValue(12));

    arrayStructure.deleteIndex(2);
    arrayStructure.printArray();
    arrayStructure.insertValue(123);
    arrayStructure.printArray();
    arrayStructure.linearSearchForValue(123);*/
    arrayStructure.bubbleSort();
  }

}