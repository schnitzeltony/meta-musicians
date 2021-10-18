SUMMARY = "Audio plugin host"
HOMEPAGE = "http://kxstudio.linuxaudio.org/Applications:Carla"
LICENSE = "GPLv2 & LGPLv3"
LIC_FILES_CHKSUM = " \
    file://doc/GPL.txt;md5=4641e94ec96f98fabc56ff9cc48be14b \
    file://doc/LGPL.txt;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

SRC_URI = " \
    git://github.com/falkTX/Carla.git;branch=main \
    file://0001-do-not-try-to-cross-run-carla-lv2-export.patch \
    file://0002-Do-not-try-to-find-Qt5-host-bins-it-won-t-work.patch \
"
SRCREV = "b02121e9a2cc6229b3863a54405c52614471895c"
S = "${WORKDIR}/git"
PV = "2.4.0"

REQUIRED_DISTRO_FEATURES = "x11"

inherit qmake5_base python3native pkgconfig qemu-ext-musicians features_check mime mime-xdg gtk-icon-cache

B = "${S}"

DEPENDS += " \
    python3-pyqt5-native \
    qtbase-native \
    qtbase \
    gtk+ \
    gtk+3 \
    liblo \
    pulseaudio \
    fluidsynth \
    libsndfile1 \
"

EXTRA_OEMAKE += " \
    DEFAULT_QT=5 \
    NOOPT=true \
    HAVE_PYQT=true \
    HAVE_PYQT4=false \
    HAVE_PYQT5=true \
    SKIP_STRIPPING=true \
"

export QT5_HOSTBINS="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}"

do_configure() {
    oe_runmake features
}

do_compile:append() {
    cd ${S}/bin
    ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', 'carla-lv2-export')}
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/mime \
    ${libdir}/jack \
    ${libdir}/lv2 \
    ${libdir}/vst \
"

INSANE_SKIP:${PN} = "dev-so"

RDEPENDS:${PN} += "python3-pyqt5 bash"
