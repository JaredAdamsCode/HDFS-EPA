package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper11 extends Mapper<LongWritable, Text, Text, DoubleWritable>{
	
//	public static enum COUNTER{
//		INVALID_RECORD_COUNT;
//	}

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split(",");
		if(delimittedLine.length > 0) {
			String rawMeasurement = delimittedLine[13].replace("\"","");
			String date = delimittedLine[11].substring(0, 5).replace("\"","");
			boolean valid = numberCheck(rawMeasurement);
			Double measurement = 0.0;
			if(valid) {
				measurement = Double.parseDouble(delimittedLine[13].replace("\"",""));
			}
			if(valid) {
				context.write(new Text(date), new DoubleWritable(measurement));

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
	        double test = Double.parseDouble(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
}
