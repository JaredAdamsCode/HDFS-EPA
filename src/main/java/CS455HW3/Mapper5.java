package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper5 extends Mapper<LongWritable, Text, Text, LongWritable>{
	
//	public static enum COUNTER{
//		INVALID_RECORD_COUNT;
//	}

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split(",");
		if(delimittedLine.length >= 3) {
			String rawMeasurement = delimittedLine[13].replace("\"","");
			boolean valid = numberCheck(rawMeasurement);
			Long measurement = (long) 0;
			if(valid) {
				measurement = Long.parseLong(delimittedLine[13].replace("\"",""));
			}
			String state = delimittedLine[0].replace("\"","");
			String average = "WC-Average";
			if(valid && (state.equals("02") || state.equals("06") || state.equals("41") || state.equals("53"))) {
				context.write(new Text(average), new LongWritable(1));

			}
//			String site = delimittedLine[0].replace("\"","") + delimittedLine[1].replace("\"","") + delimittedLine[2].replace("\"","");
//			System.out.println("state: " + state + " site: " + site);
		}
//		else {
//			context.getCounter(COUNTER.INVALID_RECORD_COUNT).increment(1);
//		}

	}
	
	public static boolean numberCheck(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        long test = Long.parseLong(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
}
