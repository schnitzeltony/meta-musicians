SUMMARY = "Ardour is a multi-channel digital audio workstation"
HOMEPAGE = "http://ardour.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

DEPENDS += " \
    gettext-native \
    gtk+ \
    gtkmm \
    cppunit \
    jack \
    alsa-lib \
    fftw \
    vamp-plugin-sdk \
    aubio \
    taglib \
    boost \
    virtual/libx11 \
    dssi \
    zlib \
    lrdf \
    rubberband \
    suil \
    lilv \
    libarchive \
    libltc \
    qm-dsp \
    fluidsynth \
    hidapi \
"

inherit waf features_check gtk-icon-cache pkgconfig python3native mime mime-xdg

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "git://github.com/Ardour/ardour.git"
SRCREV = "1734fac4105106e02219834d330fa9eb0ceef3cd"
PV = "6.8"
S = "${WORKDIR}/git"

# arch specific override - default (tested) is ARM -> no fpu-optimizations
# can be something like i686 / x86_64 see file 'wscript' in sourcepath for more details
BUILD_DIST_TARGET ??= "none"

EXTRA_OECONF = " \
    --configdir=${sysconfdir} \
    --bindir=${bindir} \
    --libdir=${libdir} \
    --optimize \
    --fpu-optimization \
    --freedesktop \
    --cxx11 \
    --no-phone-home \
    --use-external-libs \
    --qm-dsp-include=${STAGING_INCDIR}/qm-dsp \
    \
    --with-backends="jack,alsa" \
    --dist-target=${BUILD_DIST_TARGET} \
"

PATH:append = ":${B}"

# Asking fails - waf supports --bindir / --libdir
waf_preconfigure() {
}

do_configure:prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

FILES:${PN}-dev += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${libdir}/${BPN}/libardour.so \
    ${libdir}/${BPN}/libardouralsautil.so \
    ${libdir}/${BPN}/libaudiographer.so \
    ${libdir}/${BPN}/libcanvas.so \
    ${libdir}/${BPN}/libevoral.so \
    ${libdir}/${BPN}/libgtkmm2ext.so \
    ${libdir}/${BPN}/libmidipp.so \
    ${libdir}/${BPN}/libpbd.so \
    ${libdir}/${BPN}/libptformat.so \
    ${libdir}/${BPN}/libtemporal.so \
    ${libdir}/${BPN}/libwaveview.so \
    ${libdir}/${BPN}/libwidgets.so \
    ${libdir}/${BPN}/vamp/*.so \
"

FILES:${PN}-staticdev += " \
    ${libdir}/${BPN}/*.a \
"

PROVIDES = "ardour"
RPROVIDES:${PN} = "ardour"
