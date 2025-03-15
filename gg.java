// Get the tutorial overlay and steps elements
const tutorialOverlay = $('#tutorial-overlay');
const tutorialSteps = $('.tutorial-step');

// Initialize the current step index
let currentStep = 1;

// Show the tutorial overlay and first step
tutorialOverlay.show();
tutorialSteps.eq(0).addClass('active');

// Update the progress indicator
updateProgressIndicator();

// Event delegation for next step button clicks
tutorialOverlay.on('click', '.next-step', function() {
  // Hide the current step and show the next step
  $(this).closest('.tutorial-step').removeClass('active');
  tutorialSteps.eq(currentStep).addClass('active');
  
  // Update the current step index and progress indicator
  currentStep++;
  updateProgressIndicator();
});

// Event delegation for close tutorial button clicks
tutorialOverlay.on('click', '.close-tutorial', function() {
  // Hide the tutorial overlay
  tutorialOverlay.hide();
});

// Update the progress indicator
function updateProgressIndicator() {
  const progressIndicator = $('.progress-indicator');
  const currentStepText = progressIndicator.find('.current-step');
  const totalStepsText = progressIndicator.find('.total-steps');
  
  currentStepText.text(currentStep);
  totalStepsText.text(tutorialSteps.length);
}

// Animate the tutorial steps using jQuery's animation methods
function animateTutorialSteps() {
  tutorialSteps.each(function(index) {
    const step = $(this);
    const delay = index * 500; // 500ms delay between each step
    
    step.delay(delay).fadeIn(500).delay(2000).fadeOut(500);
  });
}