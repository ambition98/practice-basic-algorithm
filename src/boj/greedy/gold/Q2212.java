package boj.greedy.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2212 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numOfSensor = Integer.parseInt(br.readLine());
		int numOfBase = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] sensor = new int[numOfSensor];
		for(int i=0; i<numOfSensor; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		
		int[] gapOfSensor = new int[numOfSensor-1];
		for(int i=0; i<gapOfSensor.length; i++) {
			gapOfSensor[i] = sensor[i+1] - sensor[i];
		}
		
		Arrays.sort(gapOfSensor);
		
		int sum = 0;
		for(int i=0; i<gapOfSensor.length - (numOfBase-1); i++) {
			sum += gapOfSensor[i];
		}
		
		System.out.println(sum);
	}

}
