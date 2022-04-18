package zuoras3;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

public class s3 {
	final static AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("choose");

		int choice = sc.nextInt();
		while (true) {
			switch (choice) {
			case 1:
				createbucket();
			case 2:
				listBucket();
			case 3:
				upload();
			case 0:
				System.exit(0);
			}
		}

	}

	private static void upload() {
		// TODO Auto-generated method stub
		String bucketname = "zuora34";
		String keyname = "demo.txt";
		String filepath = "D://aws/demo.txt";
		try {
			s3.putObject(bucketname, keyname, new File(filepath));
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		}
	}

	public static void createbucket() {

		String bucket_name = "zuora34";
		try {
			s3.createBucket(bucket_name);

		} catch (AmazonS3Exception e) {
			System.err.println(e.getErrorMessage());
		}
	}

	public static void listBucket() {
		List<Bucket> buckets = s3.listBuckets();

		System.out.println("bucket list:");
		for (Bucket b : buckets) {
			System.out.println(" " + b.getName());
		}
	}

}
