package CS455HW3;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Reducer15 extends Reducer<Text, Text, Text, Text>{

	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		String sumValues = "";
        for(Text val : values){

        	sumValues += val.toString();
        }
        context.write(key, new Text(sumValues));
	}
}
