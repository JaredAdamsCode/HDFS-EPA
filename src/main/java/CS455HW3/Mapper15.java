package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper15 extends Mapper<LongWritable, Text, Text, Text>{
	

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split("\t");
		if(delimittedLine.length > 0) {
			String state = delimittedLine[0];
			
			String rawTemp = delimittedLine[1];
			double temp = Double.parseDouble(rawTemp);
			context.write(new Text(rawTemp), new Text(state));

			
			

		}


	}
	
	
}
