import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class CreateBucket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
final AmazonS3 s3=Amazons3ClientBuilder.defaultClient();
try {
	s3.createBucket(bucket_name);
	
}catch(AmazonS3Exception e) {
	System.err.println(e.getErrorMessage());
}
	}

}
