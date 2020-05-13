package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper13 extends Mapper<LongWritable, Text, Text, DoubleWritable>{
	

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split(",");
		if(delimittedLine.length > 0) {
//			String state = delimittedLine[0].replace("\"","");
			String state = delimittedLine[0].replace("\"","");
			String month = delimittedLine[11].substring(6, 8).replace("\"", "");
			if(month.equals("06") || month.equals("07") || month.equals("08")) {
				String mapKey = state + month;
				String rawMeasurement = delimittedLine[13].replace("\"","");
				boolean valid = numberCheck(rawMeasurement);
				Double measurement = 0.0;
				if(valid) {
					measurement = Double.parseDouble(delimittedLine[13].replace("\"",""));
					context.write(new Text(mapKey), new DoubleWritable(measurement));

				}
			}

		}


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
