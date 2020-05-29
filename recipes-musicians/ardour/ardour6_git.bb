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

inherit waf features_check gtk-icon-cache pkgconfig python3native mime-xdg

REQUIRED_DISTRO_FEATURE = "x11"

SRC_URI = " \
    git://github.com/Ardour/ardour.git \
    file://0001-remove-all-build-flags-that-cause-trouble-for-cross-.patch \
    file://0002-Use-ARM-NEON-intrinsics-if-available-for-mixing-func.patch \
"
SRCREV = "360c81b815efe1e7b117ad6f96f8493f675d51bf"
PV = "6.0"
S = "${WORKDIR}/git"

# arch specific override - default (tested) is ARM -> no fpu-optimizations
# can be something like i686 / x86_64 see file 'wscript' in sourcepath for more details
BUILD_DIST_TARGET ??= "none"

EXTRA_OECONF = " \
    --configdir=${sysconfdir} \
    --bindir=${bindir} \
    --libdir=${libdir} \
    --optimize \
    --freedesktop \
    --cxx11 \
    --no-phone-home \
    --use-external-libs \
    --qm-dsp-include=${STAGING_INCDIR}/qm-dsp \
    \
    --with-backends="jack,alsa" \
    --dist-target=${BUILD_DIST_TARGET} \
"

PATH_append = ":${B}"

# Asking fails - waf supports --bindir / --libdir
waf_preconfigure() {
}

do_configure_prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

do_install_append() {
    # install icons to freedesktop locations
    for s in 16 22 32 48 256 512; do
        install -d  ${D}${datadir}/icons/hicolor/${s}x${s}/apps
        ln -s ../../../../${BPN}/resources/Ardour-icon_${s}px.png \
            ${D}${datadir}/icons/hicolor/${s}x${s}/apps/${BPN}.png
    done

    # install .desktop
    install -d  ${D}${datadir}/applications
    install -m 0644 ${B}/gtk2_ardour/ardour6.desktop ${D}${datadir}/applications
}

FILES_${PN}-dev += " \
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

FILES_${PN}-staticdev += " \
    ${libdir}/${BPN}/*.a \
"
