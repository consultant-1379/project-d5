package com.cloudmaturity.answerprocessing;

import com.cloudmaturity.answerprocessing.logic.ProcessAnswers;
import com.cloudmaturity.answerprocessing.objects.Answers;
import com.cloudmaturity.answerprocessing.objects.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AnswerProcesssingApplicationTests {

	private Answers ca1 = new Answers("test", "culture", false, true, false, true, false);
	private Answers ca2 = new Answers("test", "culture", false, true, true, true, true);
	private Answers ca3 = new Answers("test", "culture", false, false, true, false, true);
	private Answers ca4 = new Answers("test", "culture", false,  true, true, true, false);
	private Answers ca5 = new Answers("test", "culture", false, false, false, false, false);
	private Answers ca6 = new Answers("test", "culture", true, true, true, true, true);
	ProcessAnswers pa = new ProcessAnswers();
	private Result re1 = pa.process(ca1);
	private Result re2 = pa.process(ca2);
	private Result re3 = pa.process(ca3);
	private Result re4 = pa.process(ca4);
	private Result re5 = pa.process(ca5);
	private Result re6 = pa.process(ca6);

	@Test
	void testWaterfall()
	{
		Assert.isTrue(re1.getResult()==1);
		Assert.isTrue(re2.getResult()!=1);
		Assert.isTrue(re3.getResult()!=1);
		Assert.isTrue(re4.getResult()!=1);
		Assert.isTrue(re5.getResult()!=1);
		Assert.isTrue(re6.getResult()!=1);
	}

	@Test
	void testInbetween()
	{
		Assert.isTrue(re1.getResult()!=1.5);
		Assert.isTrue(re2.getResult()==1.5);
		Assert.isTrue(re3.getResult()!=1.5);
		Assert.isTrue(re4.getResult()==1.5);
		Assert.isTrue(re5.getResult()==1.5);
		Assert.isTrue(re6.getResult()!=1.5);
	}

	@Test
	void testAgile()
	{
		Assert.isTrue(re1.getResult()!=2);
		Assert.isTrue(re2.getResult()!=2);
		Assert.isTrue(re3.getResult()==2);
		Assert.isTrue(re4.getResult()!=2);
		Assert.isTrue(re5.getResult()!=2);
		Assert.isTrue(re6.getResult()!=2);
	}

	@Test
	void testCloudNative()
	{
		Assert.isTrue(re1.getResult()!=3);
		Assert.isTrue(re2.getResult()!=3);
		Assert.isTrue(re3.getResult()!=3);
		Assert.isTrue(re4.getResult()!=3);
		Assert.isTrue(re5.getResult()!=3);
		Assert.isTrue(re6.getResult()==3);
	}
}
