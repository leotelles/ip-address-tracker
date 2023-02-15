# IP Address Tracker
This is a Java Spring Boot application that tracks IP addresses and their corresponding counts, and returns the top 100 IP addresses based on the count. The application uses a combination of Hash Map and Min-Heap data structures to store the IP addresses and their counts.

## Approach
The solution is implemented using a combination of Hash Map and Min-Heap data structures. We use the HashMap to store the IP addresses and their corresponding count. A Min-Heap is used to maintain the top 100 IP addresses based on the count. When the `requestHandled()` function is called, we update the count of the IP address in the HashMap. If the IP address is not already present, we add it to the HashMap with a count of 1. If the count of an IP address changes, we update the Min-Heap. The `top100()` function returns the top 100 IP addresses from the Min-Heap. The `clear()` function clears the HashMap and Min-Heap to start afresh.

## Runtime Complexity
`requestHandled()`: O(log n) - adding/updating an element to a heap takes log n time complexity. However, in the worst case, where all the IP addresses are distinct, the heap could contain all the elements, which is 20 million in this case, hence the worst time complexity could be O(nlogn).

`top100()`: O(1) - accessing the top element of a Min-Heap takes constant time.

`clear()`: O(1) - clearing a HashMap and a Min-Heap takes constant time.

## Other Approaches
An alternative approach could be using a Trie data structure. A Trie data structure would allow for faster searching of IP addresses, and the time complexity would be O(k), where k is the length of the IP address. However, the memory requirements of the Trie could be larger than the HashMap and Min-Heap approach, which is a critical factor in this case.

## Usage
### Running the application
1. Clone the repository
2. Run the command `./mvnw spring-boot:run` to start the application
3. The application runs on http://localhost:8080

### Endpoints
- POST `/requestHandled`: accepts a JSON payload containing the IP address and increments its count
- GET `/top100`: returns a JSON payload containing the top 100 IP addresses and their counts
- POST `/clear`: clears the HashMap and Min-Heap to start afresh

### Sample Payload
POST /requestHandled

```json
{
    "ipAddress": "145.87.2.109"
}
```

## Testing
We can test this by writing unit tests to ensure that the functions behave as expected. We can also test the speed of the `top100()` function by measuring the time it takes to return the result for a given number of IP addresses. Additionally, we can generate sample data and measure the memory usage of the program to ensure that it does not exceed the available memory.