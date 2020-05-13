package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper14 extends Mapper<LongWritable, Text, Text, DoubleWritable>{
	

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split("\t");
		if(delimittedLine.length > 0) {
			String state = delimittedLine[0].substring(0, 2);
			
			String rawTemp = delimittedLine[1];
			boolean valid = numberCheck(rawTemp);
			Double measurement = 0.0;
			if(valid) {
				double temp = Double.parseDouble(rawTemp);
				context.write(new Text(state), new DoubleWritable(temp));

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
