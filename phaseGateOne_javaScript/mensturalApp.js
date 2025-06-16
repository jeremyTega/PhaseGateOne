const prompt = require('prompt-sync')();

function startDate(year, month, day) {
  try {
    const date = new Date(year, month - 1, day);
    if (date.getDate() !== day) throw new Error('Invalid date');
    return date;
  } catch (e) {
    console.error(`Invalid date: ${e.message}`);
    return null;
  }
}

function predictOvulationPeriod(startDate) {
  const ovulationDates = [];
  for (let i = 14; i <= 19; i++) {
    const ovulationDay = new Date(startDate);
    ovulationDay.setDate(startDate.getDate() + i);
    ovulationDates.push(ovulationDay);
  }
  return ovulationDates;
}

function safePeriods(startDate) {
  const safeDates = [];
  for (let i = 6; i <= 9; i++) {
    const safeDay = new Date(startDate);
    safeDay.setDate(startDate.getDate() + i);
    safeDates.push(safeDay);
  }
  return safeDates;
}

function predictPeriodEnd(startDate, periodLength) {
  const end = new Date(startDate);
  end.setDate(startDate.getDate() + periodLength - 1);
  return end;
}

function predictNextPeriod(startDate, cycleLength) {
  const nextStart = new Date(startDate);
  nextStart.setDate(startDate.getDate() + cycleLength);
  return nextStart;
}


const day = Number(prompt("Enter the day your menstrual flow starts (1-311): "));
const month = Number(prompt("Enter the month your menstrual flow starts (1-12): "));
const year = Number(prompt("Enter the year your menstrual flow starts (e.g., 2025): "));

const periodLength = Number(prompt("Enter your average period length in days (e.g., 5): "));
const cycleLength = Number(prompt("Enter your average menstrual cycle length in days (e.g., 28): "));

const start = startDate(year, month, day);
if (!start) process.exit(1);


console.log(`\nYour menstrual cycle starts on: ${start.toLocaleDateString()}`);
const end = predictPeriodEnd(start, periodLength);
console.log(`Your period may end around: ${end.toLocaleDateString()}`);

const next = predictNextPeriod(start, cycleLength);
console.log(`Your next period is expected around: ${next.toLocaleDateString()}`);

console.log("\nYour possible ovulation period is:");
predictOvulationPeriod(start).forEach(d => console.log(d.toLocaleDateString()));

console.log("\nYour safe periods are:");
safePeriods(start).forEach(d => console.log(d.toLocaleDateString()));
