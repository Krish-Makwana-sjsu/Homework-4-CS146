public class RainwaterProblem {


    public static void main(String[] args) {

        // Array in question description
        int[] elevationMap= {1, 2, 1, 4, 1, 2, 1, 5,0,0, 2, 1, 5};

        // Variable to store the total amount of water
        int result=0;

        int leftMax=Integer.MIN_VALUE;      // Maximum height of the left side of the current position
        int rightMax=Integer.MIN_VALUE;     // Maximum height of the right side of the current position

        int left=0;                         // Left pointer starting from index 0
        int right=elevationMap.length-1;    // Right pointer starting from the last index of the array

        // Loop until the left and right pointers meet
        while(left<right) {

            // Update the leftMax if the current height at the left pointer is greater than or equal to the current leftMax
            if(elevationMap[left]>=leftMax) {
                leftMax=elevationMap[left];
            }
            // Update the rightMax if the current height at the right pointer is greater than or equal to the current rightMax
            if(elevationMap[right]>=rightMax) {
                rightMax=elevationMap[right];
            }

            // Find the smaller one of the leftMax and rightMax, and subtract the current height at left or right, and add to the result
            if(leftMax<rightMax) {
                result+=leftMax-elevationMap[left++];   // Move the pointer to the right after processing
            }
            else {
                result+=rightMax-elevationMap[right--]; // Move the pointer to the left after processing
            }

        }

        // Print the result
        System.out.println("Total amount of water that can be trapped: " +result);
    }
}
