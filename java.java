
const tutorialOverlay = $('#tutorial-overlay');
const tutorialSteps = $('.tutorial-step');

x
let currentStep = 1;


tutorialOverlay.show();
tutorialSteps.eq(0).addClass('active');


updateProgressIndicator();


tutorialOverlay.on('click', '.next-step', function() {

  $(this).closest('.tutorial-step').removeClass('active');
  tutorialSteps.eq(currentStep).addClass('active');
  
  currentStep++;
  updateProgressIndicator();
});

tutorialOverlay.on('click', '.close-tutorial', function() {
  tutorialOverlay.hide();
});


function updateProgressIndicator() {
  const progressIndicator = $('.progress-indicator');
  const currentStepText = progressIndicator.find('.current-step');
  const totalStepsText = progressIndicator.find('.total-steps');
  
  currentStepText.text(currentStep);
  totalStepsText.text(tutorialSteps.length);
}

function animateTutorialSteps() {
  tutorialSteps.each(function(index) {
    const step = $(this);
    
    step.delay(delay).fadeIn(500).delay(2000).fadeOut(500);
  });
}


animateTutorialSteps();
