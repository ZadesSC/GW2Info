package io.zades.gw2info.data;

import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zades on 2/4/2016.
 */
//TODO: in the future, load from file instead of makinig it in code
public class BossTimerList
{
	private static BossTimerList sInstnce;

	private List<BossTimes> mBossTimes;

	public BossTimerList()
	{
		mBossTimes = new ArrayList<>();
		mBossTimes.add(createShadowBehemoth());
		mBossTimes.add(createFireElemental());
		mBossTimes.add(createGreatJungleWurm());
		mBossTimes.add(createShatterer());
		mBossTimes.add(createEvolvedWurm());
		mBossTimes.add(createTequatl());
		mBossTimes.add(createInquestGolem());
		mBossTimes.add(createJormag());
		mBossTimes.add(createCovington());
		mBossTimes.add(createKarkaQueen());
		mBossTimes.add(createSvanirShaman());
		mBossTimes.add(createModniir());
		mBossTimes.add(createMegadestroyer());
	}

	public static BossTimerList getInstance()
	{
		if(sInstnce == null)
		{
			sInstnce = new BossTimerList();
		}
		return sInstnce;
	}

	private BossTimes createShadowBehemoth()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 12; x++)
		{
			times.add(new LocalTime(1 + 2 * x, 45));
		}
		return new BossTimes("Shadow Behemoth", times);
	}

	private BossTimes createFireElemental()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 12; x++)
		{
			times.add(new LocalTime(2 * x, 45));
		}
		return new BossTimes("Fire Elemental", times);
	}

	private BossTimes createGreatJungleWurm()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 12; x++)
		{
			times.add(new LocalTime(1 + 2 * x, 15));
		}
		return new BossTimes("Great Jungle Wurm", times);
	}

	private BossTimes createShatterer()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 8; x++)
		{
			times.add(new LocalTime(1 + 3 * x, 0));
		}
		return new BossTimes("The Shatterer", times);
	}

	private BossTimes createEvolvedWurm()
	{
		List<LocalTime> times = new ArrayList<>();
		times.add(new LocalTime(1,0));
		times.add(new LocalTime(4,0));
		times.add(new LocalTime(8,0));
		times.add(new LocalTime(12,30));
		times.add(new LocalTime(17,0));
		times.add(new LocalTime(20,0));
		return new BossTimes("Evolved Jungle Wurm", times);
	}

	private BossTimes createTequatl()
	{
		List<LocalTime> times = new ArrayList<>();
		times.add(new LocalTime(0,0));
		times.add(new LocalTime(3,0));
		times.add(new LocalTime(7,0));
		times.add(new LocalTime(11,30));
		times.add(new LocalTime(16,0));
		times.add(new LocalTime(19,0));
		return new BossTimes("Tequatl the Sunless", times);
	}

	private BossTimes createInquestGolem()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 8; x++)
		{
			times.add(new LocalTime(2 + 3 * x, 0));
		}
		return new BossTimes("Inquest Golem Mark II", times);
	}

	private BossTimes createJormag()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 8; x++)
		{
			times.add(new LocalTime(2 + 3 * x, 30));
		}
		return new BossTimes("Claw of Jormag", times);
	}

	private BossTimes createCovington()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 8; x++)
		{
			times.add(new LocalTime(3 * x, 0));
		}
		return new BossTimes("Admiral Taidha Covington", times);
	}

	private BossTimes createKarkaQueen()
	{
		List<LocalTime> times = new ArrayList<>();
		times.add(new LocalTime(2,0));
		times.add(new LocalTime(6,0));
		times.add(new LocalTime(10,30));
		times.add(new LocalTime(15,0));
		times.add(new LocalTime(18,0));
		times.add(new LocalTime(23,0));
		return new BossTimes("Karka Queen", times);
	}

	private BossTimes createSvanirShaman()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 12; x++)
		{
			times.add(new LocalTime(2 * x, 15));
		}
		return new BossTimes("Svanir Shaman Chief", times);
	}

	private BossTimes createModniir()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 8; x++)
		{
			times.add(new LocalTime(1 + 3 * x, 30));
		}
		return new BossTimes("Modniir Ulgoth", times);
	}

	private BossTimes createMegadestroyer()
	{
		List<LocalTime> times = new ArrayList<>();
		for(int x  = 0; x< 8; x++)
		{
			times.add(new LocalTime(3 * x, 30));
		}
		return new BossTimes("Megadestroyer", times);
	}

	public List<BossTimes> getBossTimes()
	{
		return mBossTimes;
	}


	public class BossTimes
	{
		private String mBossName;
		private List<LocalTime> mBossTimes;

		public BossTimes(String name, List<LocalTime> times)
		{
			mBossName = name;
			mBossTimes = times;
		}

		public String getBossName()
		{
			return mBossName;
		}

		public List<LocalTime> getBossTimes()
		{
			return mBossTimes;
		}
	}
}
