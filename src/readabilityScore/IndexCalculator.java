package readabilityScore;

 /*
 Methods should be used in the order:

 setText(Text text),
 calculateIndex(),
 determineAge(),
 displayInformation()

 to initialize all fields and receive correct result
  */

interface IndexCalculator {
    void setText(Text text);
    void calculateIndex();
    Integer determineAge();
    void displayInformation();

}
